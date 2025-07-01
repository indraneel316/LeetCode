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

        Node curr = head;

        // --------------------------
        // 1st Pass:
        // Clone each node and insert the cloned node right after the original node
        // Example: A -> B -> C becomes A -> A' -> B -> B' -> C -> C'
        // --------------------------
        while (curr != null) {
            Node clone = new Node(curr.val);   // Create clone
            clone.next = curr.next;            // Clone points to next original node
            curr.next = clone;                 // Original points to its clone
            curr = clone.next;                 // Move to next original node
        }

        // --------------------------
        // 2nd Pass:
        // Assign random pointers for the cloned nodes
        // If original.random exists, then clone.random = original.random.next
        // Because original.random.next is the clone of that random target
        // --------------------------
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;  // Set clone's random pointer
            }
            curr = curr.next.next;  // Move to next original node
        }

        // --------------------------
        // 3rd Pass:
        // Separate the interleaved list into original and cloned lists
        // Restore the original list and extract the cloned list
        // --------------------------
        curr = head;
        Node pseudoHead = new Node(0);  // Dummy head for the cloned list
        Node copyCurr = pseudoHead;

        while (curr != null) {
            Node clone = curr.next;       // The cloned node
            curr.next = clone.next;       // Restore original node's next
            copyCurr.next = clone;        // Append clone to the cloned list
            copyCurr = clone;             // Move copy pointer
            curr = curr.next;             // Move original pointer
        }

        // Return the head of the cloned list
        return pseudoHead.next;
    }
}