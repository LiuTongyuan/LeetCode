package SlidingWindow.NoDefineLen;

/**
 * @Author lty
 * @Date 2023/12/29 14:22
 * @Description 904. 水果成篮 1516
 */
public class Num904_TotalFruit {

    public int totalFruit(int[] fruits) {
        int fir = 0, sec = 0;
        int max = 0;
        for (int i = 0; i < fruits.length - 1; i++) {
            if (fruits[i] != fruits[i + 1]) {
                fir = i;
                sec = i + 1;
                break;
            }
        }
        if (sec == 0) {
            return fruits.length;
        }
        int left = 0, right = sec;
        while (right < fruits.length) {
            if (fruits[right] == fruits[fir]) {
                fir = right;
                right++;
                max = Math.max(max, right - left);
                continue;
            }
            if (fruits[right] == fruits[sec]) {
                sec = right;
                right++;
                max = Math.max(max, right - left);
                continue;
            }
            if (fir > sec) {
                left = sec + 1;
                sec = right;
            } else {
                left = fir + 1;
                fir = right;
            }

        }
        return max;

    }
}
