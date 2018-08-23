class LRUCache {
    
    class Node{ 
        int value;
        int key;
        Node next;
        Node previous;

        public Node(int key, int value){
            this.value = value;
            this.key = key;
            this.next = null;
            this.previous = null;
        }

        public Node(int key, int value, Node nextNode){
            this.value = value;
            this.key = key;
            this.next = nextNode;
            this.previous = null;
            nextNode.previous = this;
        }
    }
    
    private Node head = null;
    private Node tail = null;
    private int maxSize = 0;
    private Map<Integer, Node> map; 
    
    public LRUCache(int capacity) {
        maxSize = capacity;
        map = new HashMap<>(); 
    }
    
    public int get(int key) {
        if(map.isEmpty()) 
            return -1;
        
        // if node exist in the map then update its ranking (remove it from its position and make it the head head)
        Node node = map.getOrDefault(key, null);
        
        if(node != null){
            updateRanks(node);
            return head.value;
        }
    
        return -1;
    }
    
    public void put(int key, int value) {
        if(maxSize <= 0) 
            return;
        
        Node node = map.getOrDefault(key, null);
        
        // if there is already a node with the given key in the map then updates its value and its ranking
        if(node != null){
            node.value = value;
            updateRanks(node);
        }else{
            // if the capacity of the cache is reached then remove the LRU one
            if(map.size() == maxSize){
                map.remove(tail.key);
                
                if(maxSize == 1){
                    head = tail = null;
                }else{
                    Node nodeBeforeTail = tail.previous;
                    tail.previous.next = null;
                    tail.previous = null;
                    tail = nodeBeforeTail;    // update tail
                }
            }
            // add the new key to the cache and to the map
            add(key, value);
            map.put(key, head);
        }
    }
    
    private void add(int key, int value){
        if(head == null){
            head = tail = new Node(key, value);
        }else{
            head = new Node(key, value, head);
        }
    }
    
    private void updateRanks(Node node){
        if(!node.equals(head)){
            if(node.equals(tail)){
                tail = node.previous;
                tail.next = null;
                node.previous = null;
            }else{
                // when the node is between the head and tail 
                Node prevNode = node.previous;
                Node nextNode = node.next;  
                // removes the node between prevNode and nextNode
                prevNode.next = nextNode;
                nextNode.previous = prevNode;
            }

            node.next = head; // changing head to reflect the ranking of LRU
            head.previous = node;
            head = node; // updating head
        }
    }
    
}
