package SLL.CircularSingleLinkedList;
import SLL.*;
import SLL.SingleLinkedList.SingleLinkedList;

public class CircularSingleLinkedList extends SingleLinkedList {

    public void insert(int data){
        super.insert(data);
        if (tail != head){
            this.tail.next = head;
        }
    }

    //----------------------------------------------------------------

    public void insertAtHead(int data){
        super.insertAtHead(data);
        this.tail.next = head;
    }

    //----------------------------------------------------------------

    public void insertAtIndex(int data, int index){
        super.insertAtIndex(data, index);
        this.tail.next = head;
    }

    //----------------------------------------------------------------

    @Override
    public void traverse (){

        if (head == null){
            System.out.println("Empty List");
            return;
        }
        Node current = head.next;
        System.out.print("["+head.data+", ");
        while (current != head){
            System.out.print(current.data);
            if(current.next != head){
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.print("]");
    }

    //----------------------------------------------------------------

    @Override
    public int search (int data){

        int counter = 0;
        if (head.data == data)  return 0;
        Node current = head.next;
        while (current != head){

            if(current.data == data){
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }



    //----------------------------------------------------------------

    public void deleteTail() {
        super.deleteTail();
        this.tail.next = head;
    }

    //----------------------------------------------------------------

    public void deleteAtIndex(int index) {
        super.deleteAtIndex(index);
        this.tail.next = head;
    }
    //----------------------------------------------------------------

}
