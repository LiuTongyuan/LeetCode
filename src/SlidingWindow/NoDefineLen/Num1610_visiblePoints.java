package SlidingWindow.NoDefineLen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author lty
 * @Date 2024/1/16 13:33
 * @Description 1610. 可见点的最大数目
 * 2147
 */
public class Num1610_visiblePoints {

    /**
     * 注意：需循环两次 2 * angles.size() 并且要考虑一个点是否多次遍历 r-l<len
     *
     * @param points
     * @param angle
     * @param location
     * @return
     */
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int countSame = 0;
        int x1 = location.get(0), y1 = location.get(1);
        for (List<Integer> point : points) {
            int x2 = point.get(0), y2 = point.get(1);
            if (x1 == x2 && y1 == y2) {

                countSame++;
            } else {
                angles.add(Math.atan2(y2 - y1, x2 - x1) * 180 / Math.PI + 180);
            }
        }
        Collections.sort(angles);
        if (angles.size() <= 1) {
            return angles.size() + countSame;
        }
        int maxSee = 0;
        int l = 0, r = 0;
        int len = angles.size();
        while (r < 2 * angles.size()) {
            double ang = angles.get(r % len) - angles.get(l % len);
            ang = ang < 0 ? ang + 360 : ang;
            if (ang <= angle && r - l < len) {
                r++;
                maxSee = Math.max(r - l, maxSee);
            } else {
                l++;
            }
        }
        return maxSee + countSame;
    }
}


