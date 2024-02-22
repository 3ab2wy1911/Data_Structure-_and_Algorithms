public class Stack<T>{
    private final Object[] data;
    private final int size;
    private int top;

    public Stack(int size){
        this.size = size;
        data = new Object[size];
        top = -1;
    }

    public void push(T value) {
        if(top == size - 1){
            throw new IllegalStateException ("Stack Overflow");
        }
        data[++top] = value;
    }

    public Object pop() {
        if(top == -1){
            throw new IllegalStateException ("Stack is Empty");
        }
        return data[top--];
    }

    public Object peek(){
        return data [top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size - 1;
    }
}
