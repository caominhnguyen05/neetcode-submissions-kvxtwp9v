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
    private int capacity;
    private int size;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
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
        if (!map.containsKey(key)) {
            Node newNode = new Node(key, value);
            addAtHead(newNode);
            map.put(key, newNode);
            this.size++;
            
            // If capacity is exceeded, remove LRU key (tail of linked list)
            if (this.size > this.capacity) {
                Node toRemove = dummyTail.prev;
                map.remove(toRemove.key);
                removeNode(toRemove);
            }
        } else {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addAtHead(node);
            map.put(key, node);
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
