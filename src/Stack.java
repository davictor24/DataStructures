public class Stack<T> {
	private int mCount; 
	private int mCapacity; 
	private T[] mArray; 
	
	public Stack(int capacity) {
		mCount = 0; 
		mCapacity = capacity; 
		mArray = (T[]) new Comparable[capacity]; 
	}
	
	public void push(T item) {
		if (mCount >= mCapacity) throw new ArrayIndexOutOfBoundsException(); 
		mArray[mCount] = item; 
		mCount++; 
	}
	
	public T peek() {
		return mArray[mCount - 1]; 
	}
	
	public T pop() {
		if (mCount <= 0) throw new ArrayIndexOutOfBoundsException(); 
		T item = mArray[mCount - 1]; 
		mArray[mCount - 1] = null; 
		mCount--; 
		return item; 
	}
	
	public int count() {
		return mCount; 
	}
}
