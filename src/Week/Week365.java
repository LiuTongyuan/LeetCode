package Week;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lty
 * @Date 2023/10/1 10:25
 * @Description
 */
public class Week365 {
    public static void main(String[] args) {
        System.out.println(new Week365().maximumTripletValue(new int[]{1000000, 1, 1000000}));
    }

    public long maximumTripletValue(int[] nums) {
        int[] lastMax = new int[nums.length];
        lastMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            lastMax[i] = Math.max(lastMax[i + 1], nums[i]);
        }
        long res = 0, maxNum = nums[0];
        for (int j = 1; j < nums.length - 1; j++) {
            if (maxNum > nums[j]) {
                res = Math.max(res, (maxNum - nums[j]) * lastMax[j + 1]);
            } else {
                maxNum = nums[j];
            }
        }
        return res;
    }

    public int minSizeSubarray(int[] nums, int target) {
        int oneTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            oneTotal += nums[i];
        }
        int loop = target / oneTotal;
        int legacy = target % oneTotal;
        if (legacy == 0) {
            return loop * nums.length;
        }
        // 滑动窗口
        int minWin = Integer.MAX_VALUE;
        boolean hasRes = false;
        int l = 0, r = 0, sum = 0;
        while (r < 2 * nums.length) {
            if (sum < legacy) {
                sum += nums[r % nums.length];
                r++;
            } else if (sum == legacy) {
                hasRes = true;
                minWin = Math.min(minWin, (r - l) + loop * nums.length);
                sum -= nums[l % nums.length];
                l++;
            } else {
                sum -= nums[l % nums.length];
                l++;
            }
        }
        if (hasRes) {
            return minWin;
        } else {
            return -1;
        }

    }

    public int[] countVisitedNodes(List<Integer> edges) {
        int[] res = new int[edges.size()];
        ArrayList<Integer> hasVisited = new ArrayList<>();
        for (int i = 0; i < edges.size(); i++) {
            // 从i开始
            if (res[i] == 0) {
                hasVisited.clear();
                hasVisited.add(i);
                int lastVis = i;
                while (true) {
                    if (res[edges.get(lastVis)] != 0) {
                        for (int j = 0; j < hasVisited.size(); j++) {
                            res[hasVisited.get(j)] = hasVisited.size() - j + res[edges.get(lastVis)];
                        }
                        break;
                    } else if (hasVisited.contains(edges.get(lastVis))) {
                        int minLen = hasVisited.size() - hasVisited.indexOf(edges.get(lastVis));
                        for (int j = 0; j < hasVisited.size(); j++) {
                            res[hasVisited.get(j)] = Math.max(hasVisited.size() - j, minLen);
                        }
                        break;
                    } else {
                        hasVisited.add(edges.get(lastVis));
                        lastVis = edges.get(lastVis);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 思路：本题中边数和节点数相同，且每个点肯定都和一条边关联。
     * 由于是有向图，那么最终一定是n-2个点入度为0，剩下两个点入度相加为2.
     * 那么最终形成的一定是一个类似于 环 + 一段线（长度可能为0，即只有环） 相连的结果。
     * @param edges
     * @return
     */
    public int[] countVisitedNodes2(List<Integer> edges) {
        int n = edges.size();
        int[] adj = new int[n];
        for(int i = 0; i < n; ++i) {
            adj[i] = edges.get(i);
        }

        int[] result = new int[n], time = new int[n];
        int clock = 1;

        for (int i = 0; i < n; ++i) {
            if(time[i] > 0) {
                continue;
            }

            int x = i, startTime = clock;
            while(time[x] == 0){
                time[x] = clock++;
                x = adj[x];
            }

            int count = clock - startTime + result[x];
            for(int k = i; k != x; k = adj[k]) {
                result[k] = count--;
            }

            for (int k = x; result[k] == 0; k = adj[k]) {
                result[k] = count;
            }
        }

        return result;
    }
}
