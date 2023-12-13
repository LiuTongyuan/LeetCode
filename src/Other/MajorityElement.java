package Other;

/**
 * @Author 年年
 * @Date 2021/12/30 16:00
 * @Description 面试题 17.10. 主要元素
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class MajorityElement {
    /**
     * Boyer-Moore 投票算法的步骤如下：
     * 维护一个候选主要元素 candidate 和候选主要元素的出现次数 count，初始时 candidate 为任意值，count=0；
     * 遍历数组 nums 中的所有元素，遍历到元素 xxx 时，进行如下操作：
     *      如果 count=0，则将 xxx 的值赋给 candidate，否则不更新 candidate 的值；
     *          如果 x=candidate，则将 count 加 1，否则将 count 减 1。
     * 遍历结束之后，如果数组 nums 中存在主要元素，则 candidate 即为主要元素，否则 candidate 可能为数组中的任意一个元素。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int nowMajorityElement = 0;
        int count = 0;
        for (int num : nums) {
            if(num == nowMajorityElement){
                count++;
            }else {
                if(count == 0){
                    nowMajorityElement = num;
                    count = 1;
                }else {
                    count--;
                }
            }
        }
        count = 0;
        for (int num : nums) {
            if(num == nowMajorityElement){
                count++;
            }
        }
        return count*2>nums.length?nowMajorityElement:-1;
    }
}
