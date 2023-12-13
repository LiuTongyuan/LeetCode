package List;

/**
 * @Author 年年
 * @Date 2022/6/8 12:35
 * @Description 234. 回文链表
 * https://leetcode.cn/problems/palindrome-linked-list/
 * <p>
 * 待优化：
 * 1.不考虑链表复原，快慢指针在寻找中间节点的过程中直接反转链
 * 表前半部分，找到中间节点之后直接从中间向两边开始比较
 * 2.hash法，比较难
 */
public class Num234_IsPalindrome1 {

    public boolean isPalindrome(ListNode head) {
        return m1(head);
    }

    /**
     * 方法一：
     * 反转后半部分链表，从两边往中间遍历
     * 类似的方法二：
     * 在从前向后找中间节点时，翻转前半部分链表，从中间往两边遍历
     *
     * @param head
     * @return
     */
    public boolean m1(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head, slow = head, last;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        last = reverseList(slow.next);
        while (last != null) {
            if (last.val != head.val) {
                return false;
            }
            last = last.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, buf;
        while (cur != null) {
            buf = cur;
            cur = cur.next;
            buf.next = pre;
            pre = buf;
        }
        return pre;
    }

    /**
     * 方法三：hash法
     * 回文数反转之后不变，一个正向计算哈希值，一个反向计算哈希值，比较反转之前和反转之后的哈希值是否相等
     * 需考虑：既然使用了hash，那么必然会可能出现碰撞，该如何解决hash碰撞的问题？
     * 算法题可以多修正几次哈希函数使其AC即可，工程应用可以先使用哈希判断，
     * 如果哈希不相等，那么一定不是回文的，
     * 如果哈希相等，再按照一般方法检验一次即可，哈希可以预判正确性
     *
     * @param head
     * @return
     */
    public boolean m3(ListNode head) {
        ListNode t = head;
        int base = 11, mod = 1000000007;
        int left = 0, right = 0, mul = 1;
        while (t != null) {
            left = (int) (((long) left * base + t.val) % mod);
            right = (int) ((right + (long) mul * t.val) % mod);
            mul = (int) ((long) mul * base % mod);
            t = t.next;
        }
        return left == right;
    }

    /**
     * 方法四：递归，打印顺序为从后向前。
     */
    ListNode temp;

    public boolean m4(ListNode head) {
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }
}
