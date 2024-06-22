package BitOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lty
 * @Date 2024/1/3 15:54
 * @Description 78. 子集
 */
public class Num78_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
