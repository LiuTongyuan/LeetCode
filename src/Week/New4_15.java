package Week;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lty
 * @Date 2024/4/15 19:12
 * @Description
 */
public class New4_15 {

    /**
     * 给定一个int数组，对数组中的元素排序，使之成为一个整数，让这个整数最大。
     * 举例：8，9，10
     * 输出9810
     * 结果将会超过int，使用string输出
     * 特殊情况，前面几位都相同，但是最后多了几位，如何判断
     *
     * @param nums
     * @return
     */
    public static String one(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                int a = nums[j], b = nums[j + 1];
                if (a * traTen(b) + b - b * traTen(a) - a < 0) {
                    // a应该往后放
                    swap(nums, j, j + 1);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(nums[i]);
        }
        return stringBuilder.toString();
    }

    public static long traTen(int num) {
        if (num == 0) {
            return 10;
        }
        long res = 1;
        while (num > 0) {
            res *= 10;
            num /= 10;
        }
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        one(new int[]{10,0, 0,Integer.MAX_VALUE,Integer.MAX_VALUE,10, 8, 9});
    }
}
