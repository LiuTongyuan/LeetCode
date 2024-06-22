package SlidingWindow.DefineLen;

/**
 * @Author lty
 * @Date 2023/12/27 16:21
 * @Description 2269. 找到一个数字的 K 美丽值
 */
public class Num2269_DivisorSubstrings {
    public int divisorSubstrings(int num, int k) {
        char[] charArray = String.valueOf(num).toCharArray();
        int now = 0;
        int n = (int) Math.pow(10, k - 1), res = 0;
        for (int i = 0; i < k - 1; i++) {
            now = now * 10 + charArray[i] - '0';
        }
        for (int i = k - 1; i < charArray.length; i++) {
            now = now % n * 10 + charArray[i] - '0';
            if (now != 0 && (num % now) == 0) {
                res++;
            }
        }
        return res;
    }
}
