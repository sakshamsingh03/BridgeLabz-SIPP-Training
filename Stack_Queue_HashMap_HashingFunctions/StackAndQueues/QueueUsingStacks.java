
import java.util.Stack;

//Queue implementation using two stacks
class QueueUsingStacks {
 private Stack<Integer> stackEnqueue;
 private Stack<Integer> stackDequeue;

 public QueueUsingStacks() {
     stackEnqueue = new Stack<>();
     stackDequeue = new Stack<>();
 }

 // Enqueue operation: Push into stackEnqueue
 public void enqueue(int value) {
     stackEnqueue.push(value);
     System.out.println("Enqueued: " + value);
 }

 // Dequeue operation: Transfer if needed and pop from stackDequeue
 public int dequeue() {
     if (isEmpty()) {
         System.out.println("Queue is empty. Cannot dequeue.");
         return -1;  // Indicating empty
     }

     if (stackDequeue.isEmpty()) {
         while (!stackEnqueue.isEmpty()) {
             stackDequeue.push(stackEnqueue.pop());
         }
     }

     int value = stackDequeue.pop();
     System.out.println("Dequeued: " + value);
     return value;
 }

 // Peek front element without removing
 public int peek() {
     if (isEmpty()) {
         System.out.println("Queue is empty. Nothing to peek.");
         return -1;
     }

     if (stackDequeue.isEmpty()) {
         while (!stackEnqueue.isEmpty()) {
             stackDequeue.push(stackEnqueue.pop());
         }
     }

     return stackDequeue.peek();
 }

 // Check if the queue is empty
 public boolean isEmpty() {
     return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
 }

 // Display queue content (for debugging)
 public void display() {
     Stack<Integer> tempStack = new Stack<>();
     System.out.println("Queue Elements (Front to Rear):");

     // Display stackDequeue elements (already in correct order)
     for (int i = stackDequeue.size() - 1; i >= 0; i--) {
         System.out.print(stackDequeue.get(i) + " ");
     }

     // Display stackEnqueue elements (reverse order)
     for (int val : stackEnqueue) {
         tempStack.push(val);
     }
     while (!tempStack.isEmpty()) {
         System.out.print(tempStack.pop() + " ");
     }

     System.out.println();
 }
 
 // Main method
 public static void main(String[] args) {
     QueueUsingStacks queue = new QueueUsingStacks();

     queue.enqueue(10);
     queue.enqueue(20);
     queue.enqueue(30);
     queue.display();

     queue.dequeue();
     queue.display();

     queue.enqueue(40);
     queue.enqueue(50);
     queue.display();

     System.out.println("Front element: " + queue.peek());

     queue.dequeue();
     queue.dequeue();
     queue.display();

     queue.dequeue();
     queue.dequeue();
     queue.dequeue();  // Attempting dequeue on empty queue
 }
}