package Reverse_Linked_List;

//206. Reverse Linked List
class IterativeSolution {
    // Iterative Solution
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode tmp = null;
        ListNode prev = null;
        while(curr != null){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
