class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {}
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private Node dummyHead;
    private Node dummyTail;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
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
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addAtHead(newNode);

        if (map.size() > this.capacity) {
            Node lru = dummyTail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
    }

    private void removeNode(Node node) {
        Node previous = node.prev;
        Node next = node.next;
        previous.next = next;
        next.prev = previous;
    }

    private void addAtHead(Node node) {
        Node oldHead = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = oldHead;
        oldHead.prev = node;
    }
}
