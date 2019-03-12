public class Queue<T> {
	private int mCount; 
	private int mCapacity; 
	private T[] mArray; 
	private int frontPtr, rearPtr; 
	
	public Queue(int capacity) {
		mCount = 0; 
		mCapacity = capacity; 
		mArray = (T[]) new Comparable[capacity]; 
		frontPtr = 0; 
		rearPtr = 0; 
	}
	
	public void enqueue(T item) {
		if (mCount >= mCapacity) throw new ArrayIndexOutOfBoundsException(); 
		mArray[rearPtr] = item; 
		rearPtr = (rearPtr + 1) % mCapacity; 
		mCount++; 
	}
	
	public T dequeue() {
		if (mCount <= 0) throw new ArrayIndexOutOfBoundsException(); 
		T item = mArray[frontPtr]; 
		mArray[frontPtr] = null; 
		frontPtr = (frontPtr + 1) % mCapacity; 
		mCount--; 
		return item; 
	}
	
	public T front() {
		return mArray[frontPtr]; 
	}
	
	public T rear() {
		return mArray[rearPtr]; 
	}
	
	public int count() {
		return mCount; 
	}
}
