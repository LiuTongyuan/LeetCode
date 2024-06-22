package Search;

/**
 * @Author lty
 * @Date 2024/1/15 14:43
 * @Description 4. 寻找两个正序数组的中位数
 * HARD
 */
public class Num4_findMedianSortedArrays {

    // TODO：
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     // 0 1 2 3
    //     // 0 1 2
    //     int len1 = nums1.length, len2 = nums2.length;
    //     int tar = (len1 + len2 - 1) / 2, step = tar;
    //     int l1 = 0, l2 = 0;
    //     while (step > 0 && l1 < len1 && l2 < len2) {
    //         int move = (step - 1) / 2;
    //         if (nums1[l1] < nums2[l2]) {
    //             move = Math.max(Math.min(move, len1 - l1 - 1), 1);
    //             l1 += move;
    //         } else if (nums2[l2] < nums1[l1]) {
    //             move = Math.max(Math.min(move, len2 - l2 - 1), 1);
    //             l2 += move;
    //         } else {
    //             if (l1 + 1 >= len1) {
    //                 move = 1;
    //                 l2 += move;
    //             } else if (l2 + 1 >= len2) {
    //                 move = 1;
    //                 l1 += move;
    //             } else if (nums1[l1 + 1] < nums2[l2 + 1]) {
    //
    //                 move = 1;
    //                 l1 += move;
    //             } else {
    //                 move = 1;
    //                 l2 += move;
    //             }
    //         }
    //         step -= move;
    //     }
    //     l1 = l2 == len2 ? tar - l2 : l1;
    //     l2 = l1 == len1 ? tar - l1 : l2;
    //
    //     if (l1 == len1) {
    //         return (len1 + len2) % 2 == 0 ? (nums2[l2] + nums2[l2 + 1]) / 2d : nums2[l2];
    //     }
    //     if (l2 == len2) {
    //         return (len1 + len2) % 2 == 0 ? (nums1[l1] + nums1[l1 + 1]) / 2d : nums1[l1];
    //     }
    //     if ((len1 + len2) % 2 == 0) {
    //         if (nums1[l1] < nums2[l2]) {
    //             int num2 = l1 + 1 < len1 ? Math.min(nums2[l2], nums1[l1 + 1]) : nums2[l2];
    //             return (nums1[l1] + num2) / 2d;
    //         } else {
    //             int num1 = l2 + 1 < len2 ? Math.min(nums1[l1], nums2[l2 + 1]) : nums1[l1];
    //             return (nums2[l2] + num1) / 2d;
    //         }
    //     } else {
    //         return Math.min(nums1[l1], nums2[l2]);
    //     }
    //
    // }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 找第tar小，从0开始计数
        int tar = (len1 + len2 + 1) / 2;
        // 已选取的最后一个
        int l1 = -1, l2 = -1;
        int step = tar;
        // 找到了两个数的索引，其中比较大的那个是第tar小
        while (step > 0) {
            int move = Math.max(step / 2, 1);
            int num1 = l1 + move < len1 ? nums1[l1 + move] : Integer.MAX_VALUE;
            int num2 = l2 + move < len2 ? nums2[l2 + move] : Integer.MAX_VALUE;
            if (num1 < num2) {
                l1 += move;
            } else {
                l2 += move;
            }
            step -= move;
        }
        int num1 = l1 > -1 ? nums1[l1] : Integer.MIN_VALUE;
        int num2 = l2 > -1 ? nums2[l2] : Integer.MIN_VALUE;
        if ((len1 + len2) % 2 == 0) {
            // 偶数个
            if (num1 > num2) {

                num2 = l1 + 1 < len1 ? nums1[l1 + 1] : Integer.MAX_VALUE;
                num2 = l2 + 1 < len2 ? Math.min(num2, nums2[l2 + 1]) : num2;

            } else {
                num1 = l2 + 1 < len2 ? nums2[l2 + 1] : Integer.MAX_VALUE;
                num1 = l1 + 1 < len1 ? Math.min(num1, nums1[l1 + 1]) : num1;
            }
            return (num1 + num2) / 2d;
        } else {

            return Math.max(num1, num2);
        }

    }
}
