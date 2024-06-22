import java.util.Arrays;

/**
 * @Author lty
 * @Date 2024/1/18 12:40
 * @Description 2171. 拿出最少数目的魔法豆
 */
public class Num2171_minimumRemoval {
    /**
     * 我们需要找到一个分界线t使得
     * 1.小于t的数字之和
     * 2.大于t的数字减去t 之和
     * 他们的和最小
     *
     * @param beans
     * @return
     */
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long maxLast = 0;
        long sum = 0;
        for (int i = 0; i < beans.length; i++) {
            sum += beans[i];
            maxLast = Math.max(maxLast, (beans.length - i) * (long) beans[i]);
        }
        return sum - maxLast;
    }
}
