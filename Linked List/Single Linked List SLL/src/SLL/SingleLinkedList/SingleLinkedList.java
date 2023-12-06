package SLL.SingleLinkedList;
import SLL.*;

public class SingleLinkedList {
    protected Node head;
    protected Node tail;
    protected int length;

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
        length++;
    }

    //----------------------------------------------------------------

    public void insertAtIndex(int data, int index){
        if (length < index || index < 0){
            System.out.println("Index out of bounds");
        return;
        }

        if (index == 0){
            insertAtHead(data);
            return;
        }

        if (index == length){
            insert(data);
            return;
        }

        int counter = 1;
        Node newNode = new Node(data);
        Node current = this.head;

        while (counter < index){
            current = current.next;
            counter++;
        }
        newNode.next = current.next;
        current.next = newNode;
        length++;
    }

    //----------------------------------------------------------------

    public void traverse (){

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

    public int search (int data){

        int counter = 0;
        Node current = head;
        while (current != null){

            if(current.data == data){
               return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }

    //----------------------------------------------------------------

    public void clear(){
        this.head = this.tail = null;
        length = 0;
    }

    //----------------------------------------------------------------

    public void deleteHead(){

        if (empty()){
            System.out.println("empty tail");
            return;
        }

        this.head = this.head.next;
        length--;
    }

    //----------------------------------------------------------------

    public void deleteTail(){

        if (empty()){
            System.out.println("Empty list");
            return;
        }

        int counter = 1;
        Node current = head;
        while(counter < length -1){
            current = current.next;
            counter ++;
        }

        this.tail = current;
        this.tail.next = null;
        length--;
    }

    //----------------------------------------------------------------

    public void deleteAtIndex(int index) {
        if (empty() || index >= length || index < 0) {
            System.out.println("Out of bounds");
            return;
        }

        if (index == 0){
            deleteHead();
            return;
        }

        if ( index == length-1){
            deleteTail();
            return;
        }

        int counter = 1;
        Node current = head;
        while(counter < index){
            current = current.next;
            counter ++;
        }
        current.next = current.next.next;
        length--;
    }
    //----------------------------------------------------------------

}
