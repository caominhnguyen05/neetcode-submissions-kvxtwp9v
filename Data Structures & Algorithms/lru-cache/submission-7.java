class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node() {}

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
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
        map = new HashMap<>();
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addFirst(node);
        } else {
            map.put(key, new Node(key, value));
            addFirst(map.get(key));
            if (map.size() > this.capacity) {
                Node lru = dummyTail.prev;
                map.remove(lru.key);
                removeNode(lru);
            }
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addFirst(Node node) {
        Node oldHead = dummyHead.next;
        dummyHead.next = node;
        node.next = oldHead;
        oldHead.prev = node;
        node.prev = dummyHead;
    }
}
