import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
	private int mCount; 
	public Node<T> head, tail; 
	
	public LinkedList() {
		mCount = 0; 
		head = new Node<>(null); 
		tail = new Node<>(null); 
		head.next = tail; 
		tail.previous = head; 
	}
	
	public void addFirst(T item) {
		Node<T> node = new Node<>(item); 
		node.previous = head; 
		node.next = head.next; 
		head.next.previous = node; 
		head.next = node; 
		mCount++; 
	}
	
	public void addLast(T item) {
		Node<T> node = new Node<>(item); 
		node.next = tail; 
		node.previous = tail.previous; 
		tail.previous.next = node; 
		tail.previous = node; 
		mCount++; 
	}
	
	public T removeFirst() {
		if (mCount <= 0) return null; 
		Node<T> node = head.next; 
		head.next = node.next; 
		node.next.previous = head; 
		mCount--; 
		return node.data; 
	}
	
	public T removeLast() {
		if (mCount <= 0) return null; 
		Node<T> node = tail.previous; 
		tail.previous = node.previous; 
		node.previous.next = tail; 
		mCount--; 
		return node.data; 
	}
	
	public int count() {
		return mCount; 
	}
	
	public Iterator<T> iterator() {
		return new ListIterator<T>(this); 
	}
	
	public class Node<T> {
		T data; 
		Node<T> previous; 
		Node<T> next; 
		
		public Node(T data) {
			this.data = data; 
			this.previous = null; 
			this.next = null; 
		}
	}
	
	private class ListIterator<T> implements Iterator<T> {
		LinkedList<T> list; 
		LinkedList<T>.Node<T> current; 
		
		public ListIterator(LinkedList<T> list) {
			this.list = list; 
			current = list.head; 
		}
		
		public boolean hasNext() {
			return current.next != list.tail; 
		}
		
		public T next() {
			current = current.next; 
			return current.data; 
		}
	}
}
