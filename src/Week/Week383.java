package Week;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author lty
 * @Date 2024/2/4 10:33
 * @Description
 */
public class Week383 {
    public int returnToBoundaryCount(int[] nums) {
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                count++;
            }
        }
        return count;
    }

    public int minimumTimeToInitialState(String word, int k) {
        char[] charArray = word.toCharArray();
        int opt = 1;
        while (opt * k < charArray.length) {
            int skep = opt * k;
            int i = skep;
            for (; i < charArray.length; i++) {
                if (charArray[i] != charArray[i - skep]) {
                    break;
                }
            }
            if (i == charArray.length) {
                break;
            }
            opt++;
        }
        return opt;
    }

    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length, n = image[0].length;
        int[][] res = new int[m][n];
        int[][] row = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                row[i][j] = image[i][j] - image[i][j - 1];
            }
        }

        int[][] col = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                col[i][j] = image[i][j] - image[i - 1][j];
            }
        }

        boolean[][] row2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                row2[i][j] = Math.abs(row[i][j]) <= threshold && Math.abs(row[i][j + 1]) <= threshold;
            }
        }

        boolean[][] col2 = new boolean[m][n];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                col2[i][j] = Math.abs(col[i][j]) <= threshold && Math.abs(col[i + 1][j]) <= threshold;
            }
        }

        int[][] region = new int[m][n];
        int[][] count = new int[m][n];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (row2[i - 1][j] && row2[i][j] && row2[i + 1][j] && col2[i][j - 1] && col2[i][j] && col2[i][j + 1]) {
                    region[i][j] = image[i - 1][j - 1] + image[i - 1][j] + image[i - 1][j + 1] + image[i][j - 1] + image[i][j] + image[i][j + 1] + image[i + 1][j - 1] + image[i + 1][j] + image[i + 1][j + 1];
                    region[i][j] /= 9;
                    res[i - 1][j - 1] += region[i][j];
                    res[i - 1][j] += region[i][j];
                    res[i - 1][j + 1] += region[i][j];
                    res[i][j - 1] += region[i][j];
                    res[i][j] += region[i][j];
                    res[i][j + 1] += region[i][j];
                    res[i + 1][j - 1] += region[i][j];
                    res[i + 1][j] += region[i][j];
                    res[i + 1][j + 1] += region[i][j];

                    count[i - 1][j - 1]++;
                    count[i - 1][j]++;
                    count[i - 1][j + 1]++;
                    count[i][j - 1]++;
                    count[i][j]++;
                    count[i][j + 1]++;
                    count[i + 1][j - 1]++;
                    count[i + 1][j]++;
                    count[i + 1][j + 1]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 0) {
                    res[i][j] = image[i][j];
                } else {
                    res[i][j] /= count[i][j];
                }
            }
        }
        return res;
    }

    /**
     * 错误
     * @param word
     * @param k
     * @return
     */
    public int minimumTimeToInitialState2(String word, int k) {
        char[] charArray = word.toCharArray();
        int[] charInd = new int[26];// 上一次出现的位置
        Arrays.fill(charInd, -1);
        int[] preApp = new int[charArray.length];// 上一次出现的位置
        for (int i = 0; i < charArray.length; i++) {
            preApp[i] = charInd[charArray[i] - 'a'];
            charInd[charArray[i] - 'a'] = i;
        }
        int start = charArray.length;
        int ind = charArray.length - 1;
        if (preApp[ind] != -1) {

            ind--;
            while (ind >= 0 && preApp[ind] != -1 && preApp[ind] == preApp[ind + 1] - 1) {
                ind--;
            }
            if (preApp[ind + 1] == 0) {
                int loop = ind + 1;
                int res = getMin(loop,k);
                return Math.min((charArray.length - 1) / k + 1,res/k);
            }

        }
        return (charArray.length - 1) / k + 1;

    }

    public int getMin(int a, int b) {
        int c = a % b;
        long d = (long) a * (long) b;
        // 考虑到a和b的取值如果过大，比如都是50000，则相乘会超出范围，所以强转为long提升范围
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return (int) (d / b);
    }
}
