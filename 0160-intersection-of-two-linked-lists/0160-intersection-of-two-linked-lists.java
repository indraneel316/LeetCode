/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        
        boolean isLen1 = false;
        int diff =0;
        
        dummy1.next = headA;
        dummy2.next = headB;

        
        ListNode curr1= dummy1;
        ListNode curr2 = dummy2;
        

        int len1 =0;
        int len2 =0;
        
        while(curr1.next!=null) {
            len1++;
            curr1 =curr1.next;
        }
        while(curr2.next!=null) {
            len2++;
            curr2 =curr2.next;
        }
        
        curr1 = dummy1;
        curr2 = dummy2;
        
        if(len1>len2) {
            isLen1 = true;
        }
        
        for(int i =0; i<Math.abs(len1-len2);i++) {
            if(isLen1) {
                curr1 = curr1.next;
            }
            else {
                curr2 = curr2.next;
            }
        }
        
        
        while(curr1!=null && curr2!=null) {
            
            if(curr1 == curr2) {
                return curr1;
            }
            else {
                curr1 =curr1.next;
                curr2 =curr2.next;
            }
        }
        return null;
        
    }
}