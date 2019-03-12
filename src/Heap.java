public class Heap<T extends Comparable<T>> {
	private int mCount; 
	private int mCapacity; 
	private T[] mArray; 
	
	public Heap(int capacity) {
		mCount = 0; 
		mCapacity = capacity; 
		mArray = (T[]) new Comparable[capacity]; 
	}
	
	private void minHeapify(int index) {
		int parent = ((index + 1) / 2) - 1; 
		if (parent < 0 || mArray[parent].compareTo(mArray[index]) <= 0) return; 
		T temp = mArray[parent]; 
		mArray[parent] = mArray[index]; 
		mArray[index] = temp; 
		minHeapify(parent); 
	}
	
	public void add(T item) {
		if (mCount >= mCapacity) throw new ArrayIndexOutOfBoundsException(); 
		mArray[mCount] = item; 
		minHeapify(mCount); 
		mCount++; 
	}
	
	public T getMin() {
		return mArray[0]; 
	}
	
	public T removeMin() {
		if (mCount <= 0) throw new ArrayIndexOutOfBoundsException(); 
		T item = mArray[0]; 
		mArray[0] = mArray[mCount - 1]; 
		mArray[mCount - 1] = null; 
		mCount--; 
		int index = 0; 
		while (true) {
			int rightChild = (index + 1) * 2, leftChild = rightChild - 1; 
			if (leftChild >= mCount || 
					(leftChild < mCount && rightChild >= mCount && mArray[index].compareTo(mArray[leftChild]) <= 0) || 
					(leftChild < mCount && rightChild < mCount && mArray[index].compareTo(mArray[leftChild]) <= 0 && mArray[index].compareTo(mArray[rightChild]) <= 0)) break; 
			int newIndex = (rightChild < mCount && mArray[rightChild].compareTo(mArray[leftChild]) <= 0) ? rightChild : leftChild; 
			T temp = mArray[index]; 
			mArray[index] = mArray[newIndex]; 
			mArray[newIndex] = temp; 
			index = newIndex; 
		}
		return item; 
	}
	
	public int count() {
		return mCount; 
	}
}
