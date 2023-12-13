package List;

/**
 * @Author lty
 * @Date 2023/10/12 11:17
 * @Description 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class Num21_MergeTwoLists {

    /**
     * 方法一：双指针
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), tail = dummy;
        int a, b;
        while (list1 != null || list2 != null) {
            a = list1 == null ? 101 : list1.val;
            b = list2 == null ? 101 : list2.val;
            if (a < b) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        return dummy.next;

    }
}
