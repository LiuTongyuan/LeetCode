/**
 * @Author lty
 * @Date 2024/4/9 16:57
 * @Description
 */
public class Num2529_maximumCount {
    public int maximumCount(int[] nums) {
        int negCount = 0;
        int posCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]< 0){
                negCount++;
            }
            if(nums[i]>0){
                posCount++;
            }
        }
        return Math.max(negCount, posCount);
    }
}
