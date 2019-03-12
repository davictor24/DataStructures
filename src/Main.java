import java.util.Random; 

public class Main {
	private static final int n = 100, min = 0, max = 1000; 
	private static Random rand = new Random(); 
	
	public static void main(String [] args) {
		int[] randomArray = new int[n]; 
		for (int i = 0; i < n; i++) randomArray[i] = rand.nextInt(max - min + 1) + min; 
		
		arrayListTest(randomArray); 
		heapTest(randomArray); 
		stackTest(randomArray); 
		queueTest(randomArray); 
		linkedListTest(randomArray); 
		hashMapTest(randomArray); 
	}
	
	public static void arrayListTest(int[] randomArray) {
		System.out.println("ArrayList test"); 
		ArrayList<Integer> arrayList = new ArrayList<>(); 
		for (int i = 0; i < n; i++) arrayList.add(randomArray[i]); 
		System.out.print("Contents: "); 
		for (int item : arrayList) System.out.print(item + " "); 
		System.out.println("\n3rd item: " + arrayList.get(2)); 
		for (int i = arrayList.size() - 1; i >= 0; i--) arrayList.remove(i); 
		System.out.print("Array cleared!\nContents: "); 
		for (int item : arrayList) System.out.print(item + " "); 
		System.out.println("\n"); 
	}
	
	public static void heapTest(int[] randomArray) {
		System.out.println("Heap test"); 
		Heap<Integer> heap = new Heap<>(n); 
		for (int i = 0; i < n; i++) heap.add(randomArray[i]); 
		System.out.println("Smallest item: " + heap.getMin()); 
		System.out.print("Contents: "); 
		for (int i = 0; i < n; i++) System.out.print(heap.removeMin() + " "); 
		System.out.println("\n"); 
	}
	
	public static void stackTest(int[] randomArray) {
		System.out.println("Stack test"); 
		Stack<Integer> stack = new Stack<>(n); 
		for (int i = 0; i < n; i++) stack.push(randomArray[i]); 
		System.out.print("Reverse order: "); 
		for (int i = 0; i < n; i++) System.out.print(stack.pop() + " "); 
		System.out.println("\n"); 
	}
	
	public static void queueTest(int[] randomArray) {
		System.out.println("Queue test"); 
		Queue<Integer> queue = new Queue<>(n); 
		for (int i = 0; i < n/2; i++) queue.enqueue(randomArray[i]); 
		System.out.print("Half-filled: "); 
		for (int i = 0; i < n/2; i++) System.out.print(queue.dequeue() + " "); 
		System.out.println("\nQueue cleared!"); 
		for (int i = 0; i < n; i++) queue.enqueue(randomArray[i]); 
		System.out.print("Filled: "); 
		for (int i = 0; i < n; i++) System.out.print(queue.dequeue() + " "); 
		System.out.println("\n"); 
	}
	
	public static void linkedListTest(int[] randomArray) {
		System.out.println("LinkedList test"); 
		LinkedList<Integer> linkedList = new LinkedList<>(); 
		for (int i = 0; i < n; i++) linkedList.addLast(randomArray[i]); 
		System.out.print("Iterated: "); 
		for (int item : linkedList) System.out.print(item + " "); 
		System.out.print("\nNormal order: "); 
		for (int i = 0; i < n; i++) System.out.print(linkedList.removeFirst() + " "); 
		for (int i = 0; i < n; i++) linkedList.addFirst(randomArray[i]); 
		System.out.print("\nNormal order, again (reversed twice): "); 
		for (int i = 0; i < n; i++) System.out.print(linkedList.removeLast() + " "); 
		System.out.println("\n"); 
	}
	
	public static void hashMapTest(int[] randomArray) {
		System.out.println("HashMap test"); 
		HashMap<String, String> hashMap = new HashMap<>(); 
		for (int i = 0; i < n; i++) hashMap.put("key" + randomArray[i], "value" + randomArray[i]);
		System.out.println("HashMap filled!"); 
		for (int i = 0; i < n; i += 1) System.out.println("Value for key" + randomArray[i] + ": " + hashMap.get("key" + randomArray[i])); 
		for (int i = 0; i < n; i++) hashMap.remove("key" + randomArray[i]);
		System.out.println("HashMap cleared!"); 
		for (int i = 0; i < n; i += 1) System.out.println("Value for key" + randomArray[i] + ": " + hashMap.get("key" + randomArray[i])); 
		System.out.println("\n"); 
	}
}
