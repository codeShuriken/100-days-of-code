class RotateLsit {
    public static  ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        int n;
        for (n = 0; slow.next != null; ++n)slow = slow.next;
        k %= n;
        for (int i = 0; i < (n - k); ++i)fast = fast.next;
        
        slow.next = dummy.next;
        dummy.next = fast.next;
        fast.next = null;
        
        return dummy.next;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}