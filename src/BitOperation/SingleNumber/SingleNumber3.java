package BitOperation.SingleNumber;

import java.util.Arrays;

/**
 * @Author 年年
 * @Date 2021/12/23 9:41
 * @Description LeetCode-260:只出现一次的数字 III
 * https://leetcode-cn.com/problems/single-number-iii/
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 */
public class SingleNumber3 {
    /**
     * 方法一：灵活运用^运算
     * 假设两个数字分别是a,b.
     * 先将所有的数字做^运算,得到a^b,此时我们可以通过a^b找到a与b不同的一位,如获取最右侧的1,
     * 由^运算的性质我们知道a和b在这一位上不同,在遍历数组，将这一位上为1的数字^起来就得到a,b中的一个值
     * 同时我们已经算出了a^b,且有了其中一个数字,所以我们可以得到另一个
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int bitsum = 0;
        for (int num : nums) {
            bitsum ^= num;
        }
        int choose = (bitsum&(bitsum-1))^bitsum;
        int a = 0;
        for (int num : nums) {
            if((num & choose) != 0){
                a ^= num;
            }
        }
        return new int[]{a,a^bitsum};
    }
}
