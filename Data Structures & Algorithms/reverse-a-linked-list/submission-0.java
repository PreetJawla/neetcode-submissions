/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp2 = null;
        while(head != null){
            ListNode temp3 = head;
            head = head.next;
            temp3.next = temp2;
            temp2 = temp3;
        }
        return temp2;
    }
}
