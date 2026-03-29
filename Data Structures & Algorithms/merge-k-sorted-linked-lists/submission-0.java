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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        if (pq.isEmpty()) {
            return null;
        }

        System.out.println(pq.size());

        ListNode dummy = new ListNode();
        ListNode result = dummy;

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            result.next = curr;
            if (curr.next != null) {
                pq.offer(curr.next);
            }
            result = result.next;
        }

        return dummy.next;
    }
}
