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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        ListNode slow = curr;
        ListNode fast = head;

        while(fast!= null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = curr;
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;

        ListNode freshNode  = new ListNode();
        ListNode temp = freshNode;

        while(firstHalf!= null && secondHalf!=null) {
            temp.next = firstHalf;
            firstHalf = firstHalf.next;
            temp = temp.next;
            temp.next = secondHalf;
            secondHalf = secondHalf.next;
            temp = temp.next;
        }

        while(firstHalf!=null) {
            temp.next = firstHalf;
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        
        while(secondHalf!=null) {
            temp.next = secondHalf;
            secondHalf = secondHalf.next;
            temp = temp.next;
        }

        head = freshNode.next;

    }


    public ListNode reverseList(ListNode head) {

        ListNode curr = head;

        ListNode prev = null;

        while(curr!=null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    
}