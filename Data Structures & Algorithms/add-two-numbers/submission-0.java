// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */

// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         int carry = 0;
//         ListNode toReturn = l1;
//         while(l1 != null && l2 != null && carry != 0){
//             int a = 0, b = 0;
//             if(l1 != null){
//                 a = l1.val;
//                 l1 =  l1.next;
//             }
//             if(l2 != null){
//                 b = l2.val;
//                 l2 = l2.next;
//             }
//             carry = (a+b + carry) % 10;
//             if(toReturn != null){
//             toReturn.val = (a+b + carry) / 10;
//             toReturn = toReturn.next;
//             }else{
//                 ListNode temp = new ListNode((a+b + carry) / 10);
//                 toReturn.next = temp;
//                 toReturn = toReturn.next;
//             }
//         }
//         return toReturn1;
//     }
// }
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }
}
