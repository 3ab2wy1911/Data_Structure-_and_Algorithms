package SLL.SingleLinkedList;
import SLL.*;

public class SingleLinkedList {
    private Node head;
    private Node tail;

    //----------------------------------------------------------------

    public SingleLinkedList() {
        this.head = this.tail = null;
    }

    //----------------------------------------------------------------

    public void insert(int data){

        Node newNode = new Node(data);

        if (head == null){
            this.head = this.tail = newNode;
        }
        else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    //----------------------------------------------------------------

    public void print (){

        if (head == null){
            System.out.println("Empty List");
            return;
        }
        Node current = head;
        System.out.print("[");
        while (current != null){
            System.out.print(current.data);
            if(current.next != null){
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.print("]");
    }

    //----------------------------------------------------------------

}
