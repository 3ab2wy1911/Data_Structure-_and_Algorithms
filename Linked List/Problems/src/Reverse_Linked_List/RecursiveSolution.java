package Reverse_Linked_List;

//206. Reverse Linked List
class RecursiveSolution {
    // Recursive Solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        head.next = null;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        return newHead;
    }
}
