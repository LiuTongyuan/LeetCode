import java.util.Arrays;

/**
 * @Author lty
 * @Date 2024/1/25 14:45
 * @Description 992. K 个不同整数的子数组
 */
public class Num992_subarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] nums, int k) {
        // 记录每个位置的元素上次出现的位置
        return m1(nums, k);
    }

    public int m1(int[] nums, int k) {
        // 记录每个位置的元素上次出现的位置
        int[] preInd = new int[nums.length];

        int[] ind = new int[nums.length + 1];
        Arrays.fill(ind, -1);
        for (int i = 0; i < nums.length; i++) {
            preInd[i] = ind[nums[i]];
            ind[nums[i]] = i;
        }
        int[] count = new int[nums.length + 1];
        int countOfNum = 0;
        int l = 0, r = 0;
        int res = 0;
        while (l < nums.length) {
            while (countOfNum < k && r < nums.length) {
                if (count[nums[r]] == 0) {
                    countOfNum++;
                }
                count[nums[r]]++;
                r++;
            }
            if (countOfNum == k) {
                res++;
                int rTemp = r;
                while (rTemp < nums.length && preInd[rTemp++] >= l) {
                    res++;
                }
            }


            count[nums[l]]--;
            if (count[nums[l]] == 0) {
                countOfNum--;
            }
            l++;
        }
        return res;
    }

    /**
     * 恰好包含K个不同元素的子区间个数 = 最多包含K个不同元素的子区间个数 - 最多包含K-1个不同元素的子区间个数
     *
     * @param nums
     * @param k
     * @return
     */
    public int m2(int[] nums, int k) {
        return 0;
    }
}
