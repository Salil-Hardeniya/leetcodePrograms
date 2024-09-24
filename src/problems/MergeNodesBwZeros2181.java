package problems;

public class MergeNodesBwZeros2181 {
    public static void main(String[] args) {
        int[] ar = new int[]{0,3,1,0,4,5,2,0};
        ListNode head = createListNode(ar);
        ListNode result = mergeNodes(head);
        System.out.println(result);
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = dummy;
        while(ptr != null && ptr.next != null){
            if(ptr.next.val == 0){
                ptr.next = ptr.next.next;
                ptr = ptr.next;
            }else{
                ptr.val = ptr.val + ptr.next.val;
                ptr.next = ptr.next.next;
            }
        }
        return dummy.next;
    }

    public static ListNode createListNode(int[] ar) {
        if (ar == null || ar.length == 0) {
            return null;
        }

        ListNode head = new ListNode(ar[0]);
        ListNode current = head;

        for (int i = 1; i < ar.length; i++) {
            current.next = new ListNode(ar[i]);
            current = current.next;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }

        @Override
        public String toString() {
            return val + (next != null ? " -> " + next : "");
        }
    }
}
