package BitOperation.SingleNumber;

/**
 * @Author 年年
 * @Date 2021/12/22 9:20
 * @Description LeetCode-137:只出现一次的数字 II
 * https://leetcode-cn.com/problems/single-number-ii/
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0, tempb = 0;
        for (int num : nums) {
            tempb = (b & (~num)) | ((~a) & num);
            a = b & (a ^ num);
            b = tempb;
        }
        return a | b;
    }
}
