package SlidingWindow.NoDefineLen;

/**
 * @Author lty
 * @Date 2024/1/16 10:55
 * @Description 2106. 摘水果
 */
public class Num2106_maxTotalFruits {

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int lowThe = Math.max(startPos - k, 0);
        int highThe = Math.min(startPos + k, fruits[fruits.length - 1][0]);

        int l = 0;
        while (l < fruits.length && fruits[l][0] < lowThe) {
            l++;
        }
        ;
        int sum = 0, maxSum = 0, r = l;
        while (r < fruits.length && fruits[r][0] <= highThe) {
            int dis = fruits[r][0] - fruits[l][0] + Math.min(Math.abs(startPos - fruits[r][0]), Math.abs(startPos - fruits[l][0]));
            if (dis <= k) {
                sum += fruits[r][1];
                maxSum = Math.max(sum, maxSum);
                r++;
            } else {
                sum -= fruits[l][1];
                l++;
            }
        }
        return maxSum;


    }
}
