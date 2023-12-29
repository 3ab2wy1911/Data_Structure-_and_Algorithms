package DLL.DLL;

import DLL.Node;

public class DoubleLinkedList {
    protected Node head,tail;
    protected int size;

//----------------------------------------------------------------

    public DoubleLinkedList(){
        this.head = this.tail = null;
        this.size = 0;
    }

//----------------------------------------------------------------

    public boolean isEmpty(){
        return size == 0;
    }

//----------------------------------------------------------------

    public int length(){
        return size;
    }

//----------------------------------------------------------------

    public void insert(int data){
        if(head == null){
            head = tail = new Node(data);
        }
        else {
            Node newNode = new Node(data);
            this.tail.next= newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        ++this.size;
    }

//----------------------------------------------------------------

    public void insertAtHead(int data){
        if(head == null){
            head = tail = new Node(data);
        }
        else {
            Node newNode = new Node(data);
            this.head.prev= newNode;
            newNode.next = head;
            this.head = newNode;
        }
        ++this.size;
    }

//----------------------------------------------------------------

    public void insertAt(int index, int data){
        if(index <0 || index > this.size){
            System.out.println("Out of bounds!!!");
            return;
        }

        if (index == 0) {
            this.insertAtHead(data);
            return;
        }

        if (index == this.size){
            this.insert(index);
            return;
        }

        Node curr = head;
        Node newNode = new Node(data);
        for(int i = 0; i < index-1; i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next.prev = newNode;
        curr.next = newNode;
        newNode.prev = curr;
        ++size;
    }

//----------------------------------------------------------------

    public void pop(){
        if (isEmpty()){
            System.out.println("Empty List !!!");
            return;
        }
        this.tail = this.tail.prev;
        this.tail.next = null;
        --size;
    }

//----------------------------------------------------------------

    public void removeHead(){
        if (isEmpty()){
            System.out.println("Empty List !!!");
            return;
        }
        this.head = this.head.next;
        this.head.prev = null;
        --size;
    }

//----------------------------------------------------------------

    public void removeAt(int index){
        if (isEmpty()){
            System.out.println("Empty List !!!");
            return;
        }

        if(index <0 || index > this.size){
            System.out.println("Out of bounds!!!");
            return;
        }

        if (index == 0){
            removeHead();
            return;
        }

        if (index == this.size){
            pop();
            return;
        }

        Node curr = head;
        for(int i = 0 ; i < index-1 ; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        curr.next.prev = curr;
        --size;

    }

//----------------------------------------------------------------

    public int search(int data){
        Node current = head;
        int i=0;
        for (; i<this.size-1;i++){
            if(current.data == data){
                return i;
            }
            current = current.next;
        }
        return current.data == data ? i : -1;
    }

//----------------------------------------------------------------

    public void traverse(){
        System.out.print("[");
        Node current = head;
        for (int i=0; i<this.size-1;i++){
            System.out.print(current.data+", ");
            current = current.next;
        }
        System.out.println(current.data+"]");
    }
}
