package Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lty
 * @Date 2023/10/15 15:44
 * @Description 1488. 避免洪水泛滥
 * https://leetcode.cn/problems/avoid-flood-in-the-city/description/
 */
public class Num1488_AvoidFlood {
    /**
     * 思路：贪心算法
     *
     * @param rains
     * @return
     */
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> hasWater = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                if (hasWater.containsKey(rains[i])) {
                    boolean find = false;
                    for (int j = hasWater.get(rains[i]) + 1; j < i; j++) {
                        if (rains[j] == 0) {
                            rains[j] = rains[i];
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        return new int[]{};
                    }
                }
                hasWater.put(rains[i], i);
                rains[i] = -1;
            }
        }
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                rains[i] = 1;
            }
        }
        return rains;
    }
}
