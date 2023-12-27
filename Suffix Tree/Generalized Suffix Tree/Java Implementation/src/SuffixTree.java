public class SuffixTree{
    Node root;
    String str;
    int len;

    public SuffixTree(String str) {
        this.root = new Node();
        this.str = str;
        this.len = str.length();

        for (int i = len - 1; i >= 0; i--) {
            insert(root, i, i);
        }
    }

    private void insert(Node node, int index, int suffixStart) {
        Node current = node;
        Node lastChild = new Node();

        if (current.child == null) {
            current.child = new Node();
            updateNode(current.child, index);
            return;
        }

        current = current.child;

        while (current != null) {
            if (getChar(current, index)) {
                int matchingLength = getMaximumMatchLength(current, index);

                if (matchingLength < current.length) {
                    splitAndInsert(current, matchingLength);
                }

                insert(current, index + matchingLength, suffixStart);
                return;
            } else {
                lastChild = current;
                current = current.next;
            }
        }

        Node newNode = new Node();
        newNode.edgeStart = index;
        newNode.length = len - index;
        newNode.suffixStart = suffixStart;
        lastChild.next = newNode;
    }

    private void updateNode(Node current, int index) {
        current.edgeStart = index;
        current.suffixStart = index;
        current.length = len - index;
    }

    private boolean getChar(Node current, int index) {
        return str.charAt(current.edgeStart) == str.charAt(index);
    }

    private int getMaximumMatchLength(Node current, int startingIndex) {
        int i = current.edgeStart, j = startingIndex, result = 0;

        while (i < current.length + current.edgeStart && str.charAt(i) == str.charAt(j)) {
            i++;
            j++;
            result++;
        }

        return result;
    }

    private void splitAndInsert(Node current, int matchingLength) {
        Node newNode = new Node();
        newNode.edgeStart = current.edgeStart + matchingLength;
        newNode.length = current.length - matchingLength;
        newNode.suffixStart = current.suffixStart;

        current.length = matchingLength;
        current.suffixStart = -1;

        newNode.child = current.child;
        current.child = newNode;
    }

    public void search(String searchStr) {
        search(root, 0, searchStr);
    }

    private void search(Node node, int index, String searchStr) {
        Node current = node.child;

        while (current != null && str.charAt(current.edgeStart) != searchStr.charAt(index)) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        for (int i = current.edgeStart; i < current.length + current.edgeStart && index < searchStr.length(); i++) {
            if (str.charAt(i) != searchStr.charAt(index)) {
                return;
            }
            index++;
        }

        if (index == searchStr.length()) {
            getIndex(current);
            System.out.println();
        } else if (index < searchStr.length()) {
            search(current, index, searchStr);
        }
    }

    private void getIndex(Node current) {
        if (current != null && current.suffixStart != -1) {
            System.out.print(current.suffixStart + " ");
        }

        assert current != null;
        Node node = current.child;
        while (node != null) {
            getIndex(node);
            node = node.next;
        }
    }

}