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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevTail = dummy; // end of the previous group

        ListNode curr = head;

        while (curr != null) {
            ListNode startGroup = curr;
            int i = 0;
            while (i < k - 1 && curr != null) {
                curr = curr.next;
                i++;
            }

            // Fewer than k nodes left
            if (curr == null) {
                break;
            }

            ListNode nextHead = curr.next;
            curr.next = null;

            ListNode newHead = reverseList(startGroup);

            // Connect previous group tail to this group new head
            prevTail.next = newHead;

            // Connect this group tail to next group head
            startGroup.next = nextHead;

            prevTail = startGroup;
            curr = nextHead;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
