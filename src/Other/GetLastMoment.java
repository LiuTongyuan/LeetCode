package Other;

/**
 * @Author 年年
 * @Date 2021/12/30 15:44
 * @Description 1503. 所有蚂蚁掉下来前的最后一刻
 * https://leetcode-cn.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */
public class GetLastMoment {
    /**
     * 思路：蚂蚁在相遇时会改变运动方向为反向并且速度不变，同时可以忽略耗时，所以可以看做没有改变运动方向，因为两只蚂蚁相遇前
     * 他们的运动方向相反，即在正负方法上各有一只蚂蚁，改变后还是这样，所以与没有改变等效
     * @param n
     * @param left
     * @param right
     * @return
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        int max= 0;
        for (int l : left) {
            max = Math.max(max,l);
        }
        for (int r : right) {
            max = Math.max(max,n - r);
        }
        return max;
    }
}
