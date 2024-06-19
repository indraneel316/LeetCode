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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
       ListNode result = new ListNode();
       ListNode node = result;
       ListNode dummy1 = new ListNode();
       ListNode dummy2 = new ListNode();

       dummy1.next = list1;
       dummy2.next = list2;

       ListNode curr = dummy1;
        ListNode curr2 = dummy2;
        for(int i =0; i<a;i++) {
            curr = curr.next;
        }
        ListNode afterB = curr;
        
        for(int i=a;i<=b;i++) {
            afterB = afterB.next;
        }
        
        curr.next = list2;
        while(curr.next!=null) {
            curr = curr.next;
        }
        curr.next = afterB.next;
        
        return dummy1.next;
        
        
    }
        
}