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
        if (head == null || k <= 1) return head;

        // Dummy node to handle edge cases like reversing the first group
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 'prev' will point to the node before the group we want to reverse
        ListNode prev = dummy;

        // Loop until we reach the end of the list
        while (true) {
            // Find the kth node from 'prev'
            ListNode end = getKth(prev, k);
            if (end == null) break; // Not enough nodes to reverse

            // Mark the next group’s starting node
            ListNode next = end.next;

            // First node of the group to reverse
            ListNode start = prev.next;

            // Reverse the group from 'start' to 'end'
            reverse(start, end);

            // Connect previous part to the new head (which is 'end' after reversal)
            prev.next = end;

            // Connect the tail of the reversed group (original 'start') to the next group
            start.next = next;

            // Move 'prev' to the end of the reversed group (which is 'start' now)
            prev = start;
        }

        // Return the new head of the list
        return dummy.next;
    }

    // Helper to get the kth node from a given node
    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    // Helper to reverse the nodes from 'start' to 'end'
    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode stop = end.next; // Stop just after 'end'

        // Standard reverse loop until we reach the stop point
        while (curr != stop) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
