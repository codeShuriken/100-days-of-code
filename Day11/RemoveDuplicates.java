import java.util.Set;
import java.util.HashSet;

class RemoveDuplicates{
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(2);
        printList(head);
        ListNode newList = removeDuplicates(head);
        printList(newList);

    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    //1 - 2 - 1 - 5 - 2 - None
    //1 - 2 - 5 - None
    public static ListNode removeDuplicates(ListNode head){
        if (head == null || head.next == null)return head;
        ListNode cur = head, prev = null;
        Set<Integer> set = new HashSet<>();
        while (cur != null){
            if (set.contains(cur.val)){
              prev.next = cur.next;
            }else{
                set.add(cur.val);
                prev = cur;
            }
            
            cur = cur.next;
        }
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}