package List;


import List.ListNode;

/**
 * @Author 年年
 * @Date 2022/7/1 10:39
 * @Description LeetCode-86. 分隔链表
 * https://leetcode.cn/problems/partition-list/
 */
public class Num86_PartitionList {
    /**
     * 需要考虑：
     * 1.无需在同一个链表内操作，可先拆分为两个，再合并
     * 2.在合并两个链表时，缓存大于等于x值得链表尾结点需指向null，不然可能成环
     *
     * @param head
     * @param x    阈值 <在前面  >=在后面
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode ls = new ListNode(), le = ls;
        ListNode rs = new ListNode(), re = rs;
        ListNode next = head, cur;
        while (next != null) {
            cur = next;
            next = next.next;
            if (cur.val < x) {
                le.next = cur;
                le = cur;
            } else {
                re.next = cur;
                re = cur;
            }
        }
        le.next = rs.next;
        re.next = null;
        return ls.next;
    }
}
