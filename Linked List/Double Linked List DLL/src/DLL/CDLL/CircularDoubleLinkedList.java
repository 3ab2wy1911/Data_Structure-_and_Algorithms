package DLL.CDLL;

import DLL.DLL.DoubleLinkedList;

public class CircularDoubleLinkedList extends DoubleLinkedList {

    @Override
    public void insert(int data) {
        super.insert(data);
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }

//----------------------------------------------------------------

    @Override
    public void insertAtHead(int data) {
        super.insertAtHead(data);
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }

//----------------------------------------------------------------

    @Override
    public void removeHead(){
        super.removeHead();
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }

//----------------------------------------------------------------

    @Override
    public void pop() {
        super.pop();
        this.head.prev = this.tail;
        this.tail.next = this.head;
    }
}
