package Convert_Binary_Number_in_a_Linked_List_to_Integer;

//LeetCode: 1290. Convert Binary Number in a Linked List to Integer

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public int getDecimalValue(ListNode head) {
        int n=0, cnt =0;
        ListNode temp = head.next;
        while (temp != null){
            temp = temp.next;
            ++cnt;
        }

        while (head != null){
            n += (head.val * Math.pow(2,cnt));
            head = head.next;
            --cnt;
        }
        return n;
    }
}