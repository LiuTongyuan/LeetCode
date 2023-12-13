package Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 年年
 * @Date 2021/12/27 9:59
 * @Description 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] o1,int[] o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }else {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> results = new ArrayList<>();
        int start = intervals[0][0],end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=end){
                end = Math.max(intervals[i][1],end);
            }else {
                results.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        results.add(new int[]{start,end});
        return (int[][]) results.toArray(new int[results.size()][]);
    }
}
