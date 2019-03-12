public class HashMap<T, U> {
	private static final int MIN_CAPACITY = 16; 
	private static final double LOAD_FACTOR = 0.75; 
	private int mCount = 0; 
	private HashMapItem<T, U>[] mArray = (HashMapItem<T, U>[]) new HashMapItem[MIN_CAPACITY]; 
	
	public HashMap() {
	}
	
	private void rehash(int newCapacity) {
		HashMapItem<T, U>[] newArray = (HashMapItem<T, U>[]) new HashMapItem[newCapacity]; 
		for (HashMapItem<T, U> hashMapItem : mArray) {
			if (hashMapItem != null) {
				HashMapItem<T, U> currentNode = hashMapItem; 
				while (currentNode != null) {
					putInArray(currentNode.key, currentNode.value, newArray); 
					currentNode = currentNode.next; 
				}
			}
		}
		mArray = newArray; 
	}
	
	private int hashFunction(T key, int arrayCapacity) {
		return Math.abs(key.hashCode()) % arrayCapacity; 
	}
	
	private boolean putInArray(T key, U value, HashMapItem<T, U>[] array) {
		boolean duplicateKey = false; 
		int index = hashFunction(key, array.length); 
		HashMapItem<T, U> hashMapItem = array[index]; 
		if (hashMapItem == null) array[index] = new HashMapItem<T, U>(key, value); 
		else {
			HashMapItem<T, U> currentNode = hashMapItem; 
			while (true) {
				if (currentNode.key.equals(key)) {
					currentNode.value = value; 
					duplicateKey = true; 
					break; 
				}
				else if (currentNode.next != null) currentNode = currentNode.next; 
				else break; 
			}
			if (!duplicateKey) currentNode.next = new HashMapItem<T, U>(key, value); 
		}
		return duplicateKey; 
	}
	
	public void put(T key, U value) {
		if (mCount >= mArray.length * LOAD_FACTOR) rehash(mArray.length << 1); 
		boolean duplicateKey = putInArray(key, value, mArray); 
		if (!duplicateKey) mCount++; 
	}
	
	public U get(T key) {
		int index = hashFunction(key, mArray.length); 
		HashMapItem<T, U> hashMapItem = mArray[index]; 
		if (hashMapItem != null) {
			HashMapItem<T, U> currentNode = hashMapItem; 
			while (currentNode != null) {
				if (currentNode.key.equals(key)) return currentNode.value; 
				currentNode = currentNode.next; 
			}
		}
		return null; 
	}
	
	public U remove(T key) {
		U removedItem = null; 
		int index = hashFunction(key, mArray.length); 
		HashMapItem<T, U> hashMapItem = mArray[index]; 
		if (hashMapItem != null) {
			HashMapItem<T, U> currentNode = hashMapItem; 
			HashMapItem<T, U> previousNode = null; 
			while (currentNode != null) {
				if (currentNode.key.equals(key)) {
					removedItem = currentNode.value; 
					if (previousNode == null) mArray[index] = currentNode.next; 
					else previousNode.next = currentNode.next; 
					break; 
				}
				previousNode = currentNode; 
				currentNode = currentNode.next; 
			}
		}
		if (removedItem != null) mCount--; 
		return removedItem; 
	}
	
	public int count() {
		return mCount; 
	}
	
	private class HashMapItem<T, U> {
		T key; 
		U value; 
		HashMapItem<T, U> next; 
		
		public HashMapItem(T key, U value) {
			this.key = key; 
			this.value = value; 
		}
	}
}
