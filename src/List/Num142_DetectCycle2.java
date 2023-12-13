package List;

import List.ListNode;

import java.util.HashSet;

/**
 * @Author 年年
 * @Date 2022/7/6 11:29
 * @Description 142. 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class Num142_DetectCycle2 {
    public ListNode detectCycle(ListNode head) {
        return m3(head);
    }

    /**
     * 方法一：HashSet
     * 记录出现过的节点，若重复出现则有环，若遍历结束遇到null则无环
     *
     * @param head
     * @return
     */
    public ListNode m1(ListNode head) {
        HashSet<ListNode> sets = new HashSet<>();
        ListNode buf = head;
        while (buf != null && !sets.contains(buf)) {
            sets.add(buf);
            buf = buf.next;
        }
        return buf;
    }

    /**
     * 方法二：快慢指针
     * 当链表有环时，由于速度差为1，每次快慢指针之间的距离会减小1，快指针和慢指针一定会相遇
     * 难点：如何找到环的入口
     * 错误写法：错误原因，初始赋值错误，快慢指针初始在同一个位置，只是前进速度不同
     *
     * @param head
     * @return
     */
    public ListNode m2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head.next, slow = head;// 此句及下面判断是否有环的步骤错误
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        // fast = a + b + nc
        // slow = a + b
        // a + b = nc
        // b + a = nc
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 方法二：快慢指针
     * 正确写法
     *
     * @param head
     * @return
     */
    public ListNode m3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // fast = a + b + nc
                // slow = a + b
                // a + b = nc
                // slow = nc
                // slow + a = a + nc(刚好是入环点)
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * 方法三：删除法（不可用：本题不允许改变链表结构）
     * 可以一个个删除链表节点，遇到null则无环，不然第一次遇到被删除的就是入环节点
     *
     * @param head
     * @return
     */
    public ListNode m4(ListNode head) {
        ListNode buf = head;
        return buf;
    }
}
