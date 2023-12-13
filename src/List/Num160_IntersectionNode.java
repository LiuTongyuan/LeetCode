package List;

import java.util.HashSet;

/**
 * @Author 年年
 * @Date 2022/7/2 10:52
 * @Description 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class Num160_IntersectionNode {
    /**
     * 思路解析：需找到两个链表相交的第一个节点
     * 1.链表可能相交，也可能不相交
     * 2.链表可能为null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return m2(headA, headB);
    }

    /**
     * 方法一：使用集合
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode m1(ListNode headA, ListNode headB) {
        HashSet<ListNode> sets = new HashSet<>();
        while (headA != null) {
            sets.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (sets.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * 方法二：统计两个链表长度
     * 然后长链表先走一段，接着一起往后走
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode m2(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;
        ListNode dum = headA;
        while (dum != null) {
            countA++;
            dum = dum.next;
        }
        dum = headB;
        while (dum != null) {
            countB++;
            dum = dum.next;
        }
        if (countA < countB) {
            ListNode buf = headB;
            headB = headA;
            headA = buf;
        }

        for (int i = Math.abs(countA - countB); i > 0; i--) {
            headA = headA.next;
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * 方法三：双指针
     * 分别从A,B开始走，走到末尾之后换个链表继续走，这样相当于两个指针都会走一遍A,B链表，最终一定会在null处相遇一次
     * 中间有相交的话也可能会提前相遇，因为总距离一样，走的距离一样，那么剩余距离一定也一样。
     * 注：不相交最后也一定会走到一起，都走到null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode m3(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null?headB:a.next;
            b = b == null?headA:b.next;
        }
        return a;
    }
}
