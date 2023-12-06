import SLL.CircularSingleLinkedList.CircularSingleLinkedList;
import SLL.SingleLinkedList.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        CircularSingleLinkedList circularList = new CircularSingleLinkedList();

        // Single Linked List Testing:
        // Test Inserting
        list.insert(1);  // [1]
        list.insert(2); // [1, 2]
        list.insert(3); // [1, 2, 3]
        list.insertAtHead(0);   // [0, 1, 2, 3]
        list.insertAtIndex(7,2);    // [0, 1, 7, 2, 3]

        // Traverse, Search & Length Testing
        list.traverse(); // [0, 1, 7, 2, 3]
        System.out.println("\nLength is : " + list.length());   // Length is : 5
        System.out.println("Index of element 2 : " + list.search(2));   // Index of element 2 : 3

        // Delete Testing
        list.deleteAtIndex(1);  // [0, 7, 2, 3]
        list.deleteTail();  // [0, 7, 2]
        list.deleteHead();  // [7, 2]
        list.deleteHead();  // [2]
        list.traverse(); // [2]
        System.out.println("\nLength is : " + list.length());   // Length is : 1
        System.out.println("Index of element 1 : " + list.search(1));   // Index of element 1 : -1

        // Clear & Empty testing
        list.clear();   // []
        list.traverse();    // Empty List
        System.out.println("List is Empty ? : " + list.empty());    // list is Empty ? : true

        //================================================================================================

        // Circular Linked List testing :
        // Test Inserting
        circularList.insert(1);  // [1]
        circularList.insert(2); // [1, 2]
        circularList.insert(3); // [1, 2, 3]
        circularList.insertAtHead(0);   // [0, 1, 2, 3]
        circularList.insertAtIndex(7,2);    // [0, 1, 7, 2, 3]

        // Traverse, Search & Length Testing
        circularList.traverse(); // [0, 1, 7, 2, 3]
        System.out.println("\nLength is : " + circularList.length());   // Length is : 5
        System.out.println("Index of element 2 : " + circularList.search(2));   // Index of element 2 : 3

        // Delete Testing
        circularList.deleteAtIndex(1);  // [0, 7, 2, 3]
        circularList.deleteTail();  // [0, 7, 2]
        circularList.deleteHead();  // [7, 2]
        circularList.deleteHead();  // [2]
        circularList.traverse(); // [2]
        System.out.println("\nLength is : " + circularList.length());   // Length is : 1
        System.out.println("Index of element 1 : " + circularList.search(1));   // Index of element 1 : -1

        // Clear & Empty testing
        circularList.clear();   // []
        circularList.traverse();    // Empty List
        System.out.println("List is Empty ? : " + circularList.empty());    // list is Empty ? : true
    }
}