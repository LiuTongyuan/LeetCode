package List;

/**
 * @Author 年年
 * @Date 2022/6/9 15:33
 * @Description
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode();
        ListNode cur = resultList;
        int add = 0, x, y, sum;
        while (l1 != null || l2 != null) {
            x = l1 != null ? l1.val : 0;
            y = l2 != null ? l2.val : 0;
            sum = x + y + add;
            add = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (add == 1) {
            cur.next = new ListNode(1);
        }

        return resultList.next;
    }
}
