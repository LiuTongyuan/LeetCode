import java.util.HashMap;

/**
 * @Author lty
 * @Date 2024/1/8 21:27
 * @Description 447. 回旋镖的数量
 */
public class Num447_numberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> dis = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            dis.clear();
            for (int j = 0; j < points.length; j++) {
                int temp = dis.getOrDefault(pf(points[i][1] - points[j][1], points[i][0] - points[j][0]), 0);
                dis.put(pf(points[i][1] - points[j][1], points[i][0] - points[j][0]), temp + 1);
                count += temp;
            }
        }
        return count;
    }

    public int pf(int x, int y) {
        return x * x + y * y;
    }
}
