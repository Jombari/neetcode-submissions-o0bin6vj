class LRUCache {

    private class Node {
        Node prev;
        Node next;
        int val;
        int key;
    }

    HashMap<Integer,Node> nodeTracker;
    int maxCapacity;
    Node head;
    Node tail;
    int curCapacity;

    public LRUCache(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.maxCapacity = capacity;
        nodeTracker = new HashMap<>();
        this.curCapacity = 0;
    }
    
    public int get(int key) {
        Node retrievedNode = nodeTracker.getOrDefault(key,null);
        if(retrievedNode == null)
            return -1;
        setMostRecentlyUsed(retrievedNode);
        return retrievedNode.val;
        
    }
    
    public void put(int key, int value) {
        Node newNode = nodeTracker.getOrDefault(key,null);
        if(newNode == null){
            newNode = new Node();
            if(curCapacity >= maxCapacity)
                removeLeastRecentlyUsed();
            else{
                curCapacity++;
            }
        }
        newNode.key = key;
        newNode.val = value;
        setMostRecentlyUsed(newNode);
        nodeTracker.put(key,newNode);
    }

    private void setMostRecentlyUsed(Node recentlyUsed){
        
        Node prev = recentlyUsed.prev;
        Node next = recentlyUsed.next;
        if(prev != null)
            prev.next = next;
        if(next != null)
            next.prev = prev;
        tail.prev.next = recentlyUsed;
        recentlyUsed.prev = tail.prev;
        tail.prev = recentlyUsed;
        recentlyUsed.next = tail;
    }

    private void removeLeastRecentlyUsed(){
        Node lru = head.next;
        nodeTracker.remove(lru.key);
        head.next = lru.next;
        lru.next.prev = head;
    }
}
