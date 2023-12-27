public class Node {
    public int edgeStart;
    public int suffixStart;
    public int length;
    public Node next;
    public Node child;

    public Node(int edgeStart, int suffixStart, int length, Node next, Node child) {
        this.edgeStart = edgeStart;
        this.suffixStart = suffixStart;
        this.length = length;
        this.next = next;
        this.child = child;
    }

    public Node() {}
}
