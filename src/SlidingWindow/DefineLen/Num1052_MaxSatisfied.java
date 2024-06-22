package SlidingWindow.DefineLen;

/**
 * @Author lty
 * @Date 2023/12/27 17:21
 * @Description 1052. 爱生气的书店老板
 */
public class Num1052_MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        for (int i = 0; i < customers.length; i++) {
            res += grumpy[i] == 0 ? customers[i] : 0;
        }
        int now = 0;
        for (int i = 0; i < minutes; i++) {
            now += grumpy[i] == 1 ? customers[i] : 0;
        }
        int maxAngry = now;
        for (int i = minutes; i < customers.length; i++) {
            now += grumpy[i] == 1 ? customers[i] : 0;
            now -= grumpy[i - minutes] == 1 ? customers[i - minutes] : 0;
            maxAngry = Math.max(maxAngry, now);
        }
        return res + maxAngry;
    }
}
