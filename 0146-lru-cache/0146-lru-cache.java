class Node {
    public int key, val;
    public Node next, prev;
    Node() {
        key = val = -1;
        next = prev = null;
    }

    Node(int k, int value) {
        key = k;
        val = value;
        next = prev = null;
    }
}
class LRUCache {
    private Map<Integer, Node> mpp; // Map data structure
    private int cap; // Capacity
    private Node head; // Dummy head pointer
    private Node tail; // Dummy tail pointer
    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        // Remove pointers to node
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAfterHead(Node node) {
        Node nextNode = head.next;
        head.next = node;
        nextNode.prev = node;
        node.prev = head;
        node.next = nextNode;
    }

    public LRUCache(int capacity) {
        cap = capacity; // Set the capacity
        mpp = new HashMap<>(); // Clear the cache

        head = new Node();
        tail = new Node();

        // Make the connections
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key_) {
        // Return -1 if it is not present in cache
        if (!mpp.containsKey(key_))
            return -1;
        Node node = mpp.get(key_); // Get the node
        int val = node.val; // Get the value
        deleteNode(node);
        /* Insert this node to front
        as it was recently used */
        insertAfterHead(node);
        // Return the stored value
        return val;
    }
    public void put(int key_, int value) {
        // Update the value if key is already present
        if (mpp.containsKey(key_)) {
            Node node = mpp.get(key_); // Get the node
            node.val = value; // Update the value
            // Delete the node
            deleteNode(node);
            /* Insert this node to front
            as it was recently used */
            insertAfterHead(node);
            return;
        }
        if (mpp.size() == cap) {
            Node node = tail.prev;
            mpp.remove(node.key);
            deleteNode(node);
        }
        Node newNode = new Node(key_, value);
        mpp.put(key_, newNode);
        insertAfterHead(newNode);
    }
}
