/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);

        Node curr = head.next;
        Node newCurr = newHead;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newCurr.next = newNode;
            map.put(curr, newNode);
            curr = curr.next;
            newCurr = newCurr.next;
        }


        curr = head;
        newCurr = newHead;
        while(curr != null){
            newCurr.random = map.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}