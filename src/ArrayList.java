import java.util.Iterator; 

public class ArrayList<T> implements Iterable<T> {
	private static final int MIN_CAPACITY = 10; 
	private int mCount = 0; 
	private T[] mArray = (T[]) new Object[MIN_CAPACITY]; 
	
	public ArrayList() {
	}
	
	public ArrayList(ArrayList<T> list) {
		for (T item : list) add(item); 
	}
	
	private void reallocate(int newCapacity) {
		T[] newArray = (T[]) new Object[newCapacity]; 
		for (int i = 0; i < mCount; i++) newArray[i] = mArray[i]; 
		mArray = newArray; 
	}
	
	public void add(T item) {
		if (mCount == mArray.length) reallocate(mArray.length << 1); 
		mArray[mCount] = item; 
		mCount++; 
	}
	
	public void add(int index, T item) {
		if (index < 0 || index > mCount) throw new ArrayIndexOutOfBoundsException(); 
		if (mCount == mArray.length) reallocate(mArray.length << 1); 
		for (int i = mCount; i > index; i--) mArray[i] = mArray[i - 1]; 
		mArray[index] = item; 
		mCount++; 
	}
	
	public T get(int index) {
		if (index < 0 || index >= mCount) throw new ArrayIndexOutOfBoundsException(); 
		return mArray[index]; 
	}
	
	public T remove(int index) {
		if (index < 0 || index >= mCount) throw new ArrayIndexOutOfBoundsException(); 
		T item = mArray[index]; 
		for (int i = index; i < mCount - 1; i++) mArray[i] = mArray[i + 1]; 
		mArray[mCount - 1] = null; 
		mCount--; 
		if (mArray.length >= 4 * mCount && mArray.length > MIN_CAPACITY) reallocate(mArray.length >> 1); 
		return item; 
	}
	
	public int size() {
		return mCount; 
	}
	
	public Iterator<T> iterator() {
		return new ArrayIterator<T>(this); 
	}
	
	private class ArrayIterator<T> implements Iterator<T> {
		ArrayList<T> list; 
		int index = 0; 
		
		public ArrayIterator(ArrayList<T> list) {
			this.list = list; 
		}
		
		public boolean hasNext() {
			return index < list.size(); 
		}
		
		public T next() {
			return list.get(index++); 
		}
	}
}
