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
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prevTail = dummy; // tail of the previous group
        ListNode curr = head;

        while (curr != null) {
            int i = 0;
            ListNode startGroup = curr;
            
            while (i < k - 1 && curr != null) {
                curr = curr.next;
                i++;
            }

            if (curr == null) {
                break;
            }

            ListNode nextHead = curr.next;
            curr.next = null;
            
            ListNode newHead = reverseList(startGroup);

            // Connect previous group tail to this group new head
            prevTail.next = newHead;

            // Connect new group tail to next group's head
            startGroup.next = nextHead;

            // Update pointers
            curr = nextHead;
            prevTail = startGroup;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
