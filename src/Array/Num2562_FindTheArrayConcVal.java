package Array;

/**
 * @Author lty
 * @Date 2023/10/12 09:28
 * @Description
 */
public class Num2562_FindTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        int l = 0, r = nums.length - 1;
        long concVal = 0;
        while (l < r) {
            concVal += getConcVal(nums[l++], nums[r--]);
        }
        if (l == r) {
            concVal += nums[l];
        }
        return concVal;
    }

    public long getConcVal(int a, int b) {
        return a * (int) Math.pow(10, getDigit(b)) + b;
    }

    public int getDigit(int num) {
        int digit = 1;
        while (num >= Math.pow(10, digit)) {
            digit++;
        }
        return digit;
    }
}
