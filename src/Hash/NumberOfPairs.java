package Hash;

/**
 * @Author lty
 * @Date 2023/2/16 10:22
 * @Description 2341. 数组能形成多少数对
 * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 */
public class NumberOfPairs {
    public int[] numberOfPairs(int[] nums) {
        int[] answer = new int[2];
        boolean[] hashMap = new boolean[101];
        for (int num : nums) {
            if (hashMap[num]) {
                answer[0]++;
            }
            hashMap[num] = !hashMap[num];
        }
        answer[1] = nums.length - 2 * answer[0];
        return answer;
    }
}
