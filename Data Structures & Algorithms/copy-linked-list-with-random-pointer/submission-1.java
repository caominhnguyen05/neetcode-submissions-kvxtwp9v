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
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node dummy = new Node(0);
        Node current = dummy;

        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new Node(head.val));
            }

            Node copy = map.get(head);
            current.next = copy;
            current = copy;

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new Node(head.random.val));
                }
                current.random = map.get(head.random);
            }
            head = head.next;
        }

        return dummy.next;
    }
}
