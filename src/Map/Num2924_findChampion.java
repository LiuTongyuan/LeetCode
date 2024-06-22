package Map;

/**
 * @Author lty
 * @Date 2024/4/13 09:37
 * @Description
 */
public class Num2924_findChampion {
    public int findChampion(int n, int[][] edges) {
        int[] in = new int[n];
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            in[edges[i][1]]++;
            if (in[edges[i][1]] == 1) {
                count++;
            }
        }
        if (count != n - 1) {
            return -1;
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
