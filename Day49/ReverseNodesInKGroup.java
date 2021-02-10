public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
       if (head == null || head.next == null || k == 1)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode begin = dummy, end = head;
        int i = 0;
        while (end != null){
            if (++i % k == 0){
                begin = reverse(begin, end.next);
                end = begin.next;
            }else{
                end = end.next;
            }
        }
        return dummy.next;
    }
    
    //0 - 1 - 2 - 3 - 4
    //B               E
    //0 <- 1 <- 2 <- 3 -> 4
    private static ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin, cur = begin.next, tempCur = cur;
        ListNode next;
        while (cur != end){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        begin.next = prev;
        tempCur.next = cur;
        return tempCur;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}