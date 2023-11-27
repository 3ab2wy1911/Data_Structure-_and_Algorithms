package SLL.SingleLinkedList;
import SLL.*;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    //----------------------------------------------------------------

    public SingleLinkedList() {
        this.head = this.tail = null;
        this.length = 0;
    }

    //----------------------------------------------------------------

    public int length(){
        return this.length;
    }

    //----------------------------------------------------------------

    public boolean empty(){
        return this.head == null;
    }

    //----------------------------------------------------------------

    public void insert(int data){

        Node newNode = new Node(data);

        if (empty()){
            this.head = this.tail = newNode;
        }
        else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
        length++;
    }

    //----------------------------------------------------------------

    public void insertAtHead(int data){

        Node newNode = new Node(data);

        if (empty()){
            this.head = this.tail = newNode;
        }
        else{
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    //----------------------------------------------------------------

    public void insertAtIndex(int data, int index){
        if (length < index || index < 0){
            System.out.println("Index out of bounds");
        return;
        }

        int counter = 0;
        Node newNode = new Node(data);
        Node current = this.head;

        while (counter <= index){
            current = current.next;
            counter++;
        }
        newNode.next = current.next;
        current.next = newNode;
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
