package List;

/**
 * @Author lty
 * @Date 2024/5/21 18:25
 * @Description
 */
public class Num25_reverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            if(nextHead == null){
                return head;
            }else {
                nextHead = nextHead.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode start = head,next = null;
        while (start!=nextHead){
            next = start.next;
            start.next = dummy.next;
            dummy.next = start;
            start = next;
        }
        head.next = reverseKGroup(nextHead,k);
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(),cur = head;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        ListNode res = reverseKGroup(head.next,2);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
