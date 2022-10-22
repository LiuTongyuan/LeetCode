package List.DeleteDuplicates;

import List.ListNode;

/**
 * @Author 年年
 * @Date 2022/2/28 9:11
 * @Description 82 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy, right = dummy.next;
        while (right != null) {
            if (right.next == null || right.next.val != left.next.val) {
                if (left.next != right) {
                    left.next = right.next;
                } else {
                    left = right;
                }
            }
            right = right.next;
        }
        return dummy.next;
    }
}
