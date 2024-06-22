/**
 * @Author lty
 * @Date 2024/1/22 14:42
 * @Description
 */
public class Num670_maximumSwap {

    public int maximumSwap(int num) {
        int res = num;
        int max = num % 10;
        int maxIndex = 0;
        int temp = num / 10;
        for (int i = 1; temp > 0; i++, temp /= 10) {
            int cur = temp % 10;
            if (cur > max) {

                maxIndex = i;
                max = cur;
            } else if (cur < max) {
                res = (int) (num - cur * Math.pow(10, i) - max * Math.pow(10, maxIndex) + cur * Math.pow(10, maxIndex) + max * Math.pow(10, i));
            }
        }
        return res;
    }
}
