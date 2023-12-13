package Other;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @Author lty
 * @Date 2023/1/17 11:05
 * @Description 1488. 避免洪水泛滥
 * https://leetcode.cn/problems/avoid-flood-in-the-city/
 */
public class AvoidFlood {

    /**
     * 思路：
     * 记录下每个池子上次下雨的时间 和 现在可以用来抽水的天数
     * 遍历：
     * 第i天下雨：
     *      判断池子rains[i]是否存有雨水，有：
     *          遍历可以用的天数，找到上次下雨后的第一天，用来抽干rains[i]，更新rains[i]最新的下雨天数，删除一个可以用来抽水的天数
     *          没找到则返回null
     *      无雨水：
     *          记录下rains[i]的下雨时间
     * 不下雨：
     *      记录一个可以用来抽水的天数
     * @param rains
     * @return
     */
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> hasRained = new HashMap<>();// 保存已经有水的池子
        LinkedHashSet<Integer> notRained = new LinkedHashSet<>();// 保存没下雨且还没抽过水的天数
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                // 第i天在rains[i]下雨了
                res[i] = -1;
                if (hasRained.containsKey(rains[i])) {
                    // 之前在rains[i]下过雨
                    int choosedDay = 0;
                    for (int j : notRained) {
                        if (j > hasRained.get(rains[i])) {
                            choosedDay = j;
                            res[choosedDay] = rains[i];
                            break;
                        }
                    }
                    if (choosedDay == 0){
                        return new int[0];
                    }else {
                        notRained.remove(choosedDay);
                    }
                } else {
                    // 之前在rains[i]没下过雨
                    hasRained.put(rains[i], i);
                }
            } else {
                // 第i天没下雨
                notRained.add(i);
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                res[i] = 1;
            }
        }
        return res;
    }
}
