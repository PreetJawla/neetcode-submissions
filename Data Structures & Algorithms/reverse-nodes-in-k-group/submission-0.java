class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        // Count total nodes
        int totalNodes = countNodes(head);
        int fullGroups = totalNodes / k;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        ListNode curr = head;

        for (int i = 0; i < fullGroups; i++) {
            // Identify group start and end
            ListNode groupStart = curr;
            ListNode prev = null;

            // Reverse k nodes
            for (int j = 0; j < k; j++) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            // Connect reversed group to the main list
            groupPrev.next = prev;
            groupStart.next = curr;
            groupPrev = groupStart;
        }

        return dummy.next;
    }

    private int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
