class LRUCache {

    class Node {
        int data;
        Node next;
        Node prev;
        int key;

        public Node(int data){
            this.data = data;
        }
        public Node(){

        }
    }

    Node lru;
    Node mru;
    HashMap<Integer,Node> map ;
    int capacity;
    int currSize;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.lru = new Node();
        this.mru = new Node();
        this.capacity = capacity;
        this.currSize = 0;
        this.lru.next = this.mru;
        this.mru.prev = this.lru;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node retrievedNode = map.get(key);
        setMostRecent(retrievedNode);
        return retrievedNode.data;

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node updateNode = map.get(key);
            updateNode.data = value;
            setMostRecent(updateNode);
            return;
        }
        if(currSize >= capacity){
            removeMostRecent();
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.data = value;
        setMostRecent(newNode);
        map.put(key,newNode);
        currSize++;
    }

    public void setMostRecent(Node newNode){
        if(newNode.prev != null && newNode.next != null){
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
        }
        Node prevMostRecent = mru.prev;
        prevMostRecent.next = newNode;
        newNode.prev=prevMostRecent;
        mru.prev = newNode;
        newNode.next = mru;
    }

    public void removeMostRecent(){
        Node removedNode = lru.next;
        map.remove(removedNode.key);
        lru.next = removedNode.next;
        lru.next.prev = lru;
        currSize--;
    }
}
