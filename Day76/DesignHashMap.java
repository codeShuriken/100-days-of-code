class DesignHashMap{
    public static void main(String[] args) {
        MyHashMap hashMap  = new MyHashMap();
        hashMap.put(1, 1);          
        hashMap.put(2, 2);         
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1 
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found) 
    }
}

/**
 * Follow-up Questions
 * 
 * For simplicity, are the keys integers only?
 * For collision resolution, can we use chaining?
 * Do we have to worry about load factors?
 * Can we assume inputs are valid or do we have to validate them?
 * Can we assume this fits memory?
 */

class MyHashMap {
    final ListNode[] map = new ListNode[10000];
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = idx(key);
        if (map[i] == null){
            map[i] = new ListNode(-1, -1);
        }
        ListNode prev = find(map[i], key);
        if (prev.next != null){
            prev.next.val = value;
        }else 
            prev.next = new ListNode(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = idx(key);
        if (map[i] == null)return -1;
        ListNode prev = find(map[i], key);
        return (prev.next != null) ? prev.next.val : -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = idx(key);
        if (map[i] == null)return;
        ListNode prev = find(map[i], key);
        if (prev.next != null){
            prev.next = prev.next.next;
        }
    }
    
    
    public int idx(int key){
        return Integer.hashCode(key)%map.length;
    }
    
    public ListNode find(ListNode node, int key){
        ListNode n = node, prev = null;
        while (n != null && n.key != key){
            prev = n;
            n= n.next;
        }
        return prev;
    }
}

class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode(int key, int val){
        this.key=key;
        this.val=val;
    }
}