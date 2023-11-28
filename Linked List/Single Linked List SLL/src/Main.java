import SLL.SingleLinkedList.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

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
    }
}