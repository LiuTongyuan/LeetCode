package Greedy;

/**
 * @Author lty
 * @Date 2024/4/1 16:09
 * @Description
 */
public class Num376_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int prediff = 0;
        int count = 1;
        int diff = 0;
        for (int i = 1; i < nums.length; i++) {
            diff = nums[i] - nums[i - 1];
            if(diff != 0){
                if(diff * prediff <=0){
                    count ++;
                }
                prediff = diff;
            }
        }
        return count;
    }
}
