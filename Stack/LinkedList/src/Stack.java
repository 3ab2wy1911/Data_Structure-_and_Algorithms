public class Stack <T>{
    private Node<T> head;

    public Stack() {
        head = null;
    }

    public void push (T value) {
        Node<T> node =new Node<>(value);
        if(head == null){
            head = node;
        }
        node.next = head;
        head = node;
    }

    public Object pop () {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        Object tmp = head.data;
        head = head.next;
        return tmp;
    }

    public Object peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

}
