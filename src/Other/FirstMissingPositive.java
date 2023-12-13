package Other;

/**
 * @Author 年年
 * @Date 2021/12/23 11:08
 * @Description 41. 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    /**
     * 方法一：原地hash
     * 由于要找第一个没有出现的正数，我们可以将下标和hash联系起来，当出现了某个正数，我们就将其值对应的
     * 下标改为负数，但是数组刚开始就有负数
     * 那怎么办呢？由于数组长度优先，消失的第一个正数一定小于等于nums.length
     * 我们可以先对数据进行预处理，将最开始的数组中的负数改为nums.length+1，因为nums.length+1是我们不在意的正数
     * 此时就完成了正负数的统一。
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]<=0){
                nums[i] = n+1;
            }
        }
        for (int i = 0; i <n; i++) {
            if(Math.abs(nums[i])<= n){
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}
