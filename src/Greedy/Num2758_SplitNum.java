package Greedy;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/10/9 09:47
 * @Description LeetCode-2578. 最小和分割
 * https://leetcode.cn/problems/split-with-minimum-sum/
 */
public class Num2758_SplitNum {
    /**
     * 思路贪心算法：本题和输入数字的排序关系不大，和输入数字的构成数位有关
     * 可以思考如何将一个数字变大：
     * 假设数位为 a b c d e f 六位，想要将其变大，需要交换其中两位，则需要满足 x的位数在y前 且x<y
     * 因此，如果想要得到最小数字，我们需要将大的数字放后面
     * @param num
     * @return
     */
    public int splitNum(int num) {
        char[] arr = (num + "").toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= '0';
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[arr.length - 1 - i] * (int) Math.pow(10, (int) (i / 2));
        }
        return res;
    }
}
