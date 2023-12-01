package Delete_Node_in_a_Linked_List;
//LeetCode : 237. Delete Node in a Linked List



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
