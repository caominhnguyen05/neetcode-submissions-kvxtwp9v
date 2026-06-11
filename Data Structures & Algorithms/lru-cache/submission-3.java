class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {}
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private Node dummyHead;
    private Node dummyTail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        addAtHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            map.remove(key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addAtHead(newNode);

        if (map.size() > this.capacity) {
            Node toRemove = this.dummyTail.prev;
            map.remove(toRemove.key);
            removeNode(toRemove);
        }
    }

    // Remove a node from the linked list
    private void removeNode(Node node) {
        Node previous = node.prev;
        Node next = node.next;
        previous.next = next;
        next.prev = previous;
    }

    // Add a node to the head of the linked list
    private void addAtHead(Node node) {
        Node oldHead = this.dummyHead.next;
        node.next = oldHead;
        node.prev = this.dummyHead;
        oldHead.prev = node;
        this.dummyHead.next = node;
    }
}
