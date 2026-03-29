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
        // maps old node -> copy node
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        Node dummy = new Node(0);
        Node currCopy = dummy;

        while (curr != null) {
            Node copy = null;
            
            if (!map.containsKey(curr)) {
                copy = new Node(curr.val);
                map.put(curr, copy);
            }
            copy = map.get(curr);

            currCopy.next = copy;

            if (curr.random != null) {
                if (!map.containsKey(curr.random)) {
                    Node newRandom = new Node(curr.random.val);
                    map.put(curr.random, newRandom);
                    copy.random = newRandom;
                } else {
                    copy.random = map.get(curr.random);
                }
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return dummy.next;
    }
}
