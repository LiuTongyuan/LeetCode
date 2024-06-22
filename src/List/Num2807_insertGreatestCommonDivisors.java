package List;

/**
 * @Author lty
 * @Date 2024/1/6 15:22
 * @Description
 */
public class Num2807_insertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode listNode = head;
        while (listNode.next != null) {
            ListNode next = new ListNode(getMax(Math.max(listNode.val, listNode.next.val), Math.min(listNode.val, listNode.next.val)), listNode.next);
            listNode.next = next;
            listNode = next.next;
        }
        return head;
    }

    public int getMax(int num1, int num2) {
        return num1 % num2 == 0 ? num2 : getMax(num2, num1 % num2);
    }


    /**
     * 优化写法
     */
    class Better{
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode node = head;
            while (node.next != null) {
                node.next = new ListNode(gcd(node.val, node.next.val), node.next);
                node = node.next.next;
            }
            return head;
        }

        public int gcd(int a, int b) {
            while (b != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }
    }
}



