import java.util.PriorityQueue;

class MergeKLists{
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        lists[0] = l1;
        lists[1] = l2;
        lists[2]  = l3;

        ListNode node = mergeKLists(lists);
        printList(node);

    }

    public static ListNode mergeKLists(final ListNode[] lists) {
        if (lists == null || lists.length == 0)return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists){
            if (list != null){
                pq.add(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr  = dummy;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            if (node.next != null){
                pq.add(node.next);
            }
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }

    static void printList(final ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}