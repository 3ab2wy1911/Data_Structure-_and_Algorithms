import DLL.CDLL.CircularDoubleLinkedList;
import DLL.DLL.DoubleLinkedList;

public class Main {
    public static void main(String[] args) {

        // Testing The Doubly Linked List & The Circular Doubly linked List.
        DoubleLinkedList dll = new CircularDoubleLinkedList();
        dll.insert(1);  // [1]
        dll.insert(2); // [1,2]
        dll.insert(3); // [1,2,3]
        dll.insertAtHead(5);    // [5,1,2,3]
        dll.insertAt(2,0);  // [5,1,0,2,3]
        dll.traverse(); // [5,1,0,2,3]
        dll.pop(); // [5,1,0,2]
        dll.removeHead(); // [1,0,2]
        dll.removeAt(1); // [1,2]
        dll.traverse(); // [1,2]
        System.out.println(dll.length()); // 2
        System.out.println(dll.search(0));  // -1
    }
}