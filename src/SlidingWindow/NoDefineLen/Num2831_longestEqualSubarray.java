package SlidingWindow.NoDefineLen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author lty
 * @Date 2024/1/1 15:10
 * @Description 2831. 找出最长等值子数组 1976
 */
public class Num2831_longestEqualSubarray {

    /**
     * 把相同元素分组，相同元素的下标记录到哈希表（或者数组）pos\textit{pos}pos 中。
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size(), ans = 0;
        List<Integer>[] pos = new ArrayList[n + 1];
        Arrays.setAll(pos, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            pos[x].add(i - pos[x].size());
        }
        for (List<Integer> ps : pos) {
            if (ps.size() <= ans) continue;
            int left = 0;
            for (int right = 0; right < ps.size(); right++) {
                while (ps.get(right) - ps.get(left) > k) {
                    // 要删除的数太多了
                    left++;
                }

                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
