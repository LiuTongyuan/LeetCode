package BitOperation.SingleNumber;

/**
 * @Author 年年
 * @Date 2021/12/22 9:16
 * @Description LeetCode-136:只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber1 {
    public int singleNumber(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target ^= num;
        }
        return target;
    }
}
