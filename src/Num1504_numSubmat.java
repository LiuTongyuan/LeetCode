/**
 * @Author lty
 * @Date 2024/1/16 19:40
 * @Description
 */
public class Num1504_numSubmat {
    public int numSubmat(int[][] mat) {
        int[][] row = new int[mat.length][mat[0].length];
        int[][] col = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            row[i][0] = mat[i][0];
        }
        for (int i = 0; i < mat[0].length; i++) {
            col[0][i] = mat[0][i];
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                row[i][j] = mat[i][j] == 1 ? row[i][j - 1] + 1 : 0;
            }
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                col[i][j] = mat[i][j] == 1 ? col[i - 1][j] + 1 : 0;
            }
        }
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int minRow = Integer.MAX_VALUE;
                for (int k = 0; k <= i && minRow != 0; k++) {
                    minRow = Math.min(row[i - k][j], minRow);
                    count+=minRow;
                }
            }
        }
        return count;
    }
}
