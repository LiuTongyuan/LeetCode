package SlidingWindow.DefineLen;

/**
 * @Author lty
 * @Date 2023/12/27 16:42
 * @Description 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 */
public class Num1343_NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int target = k * threshold;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int num = sum >= target ? 1 : 0;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            if (sum >= target) {
                num++;
            }
        }
        return num;
    }
}
