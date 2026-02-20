class LRUCache {
    class Node{
        Node prev , next;
        int key , value;
        public Node(int _key ,int  _value){
            key = _key;
            value = _value;
        }
    }
    Map<Integer , Node> mp = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node curNode = mp.get(key);
            remove(curNode);
            insert(curNode);
            return curNode.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        if(mp.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key , value));
    }

    private void insert(Node node){
        mp.put(node.key , node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node){
        mp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */