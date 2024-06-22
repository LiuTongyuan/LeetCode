package SlidingWindow.DefineLen;

/**
 * @Author lty
 * @Date 2023/12/27 17:12
 * @Description 2379. 得到 K 个黑块的最少涂色次数
 */
public class num2379_MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int nowW = 0;
        for (int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'W'){
                nowW++;
            }
        }
        int res = nowW;
        for (int i = k; i < blocks.length(); i++) {
            if(blocks.charAt(i) == 'W'){
                nowW++;
            }
            if(blocks.charAt(i-k) == 'W'){
                nowW--;
            }
            res = Math.min(nowW, res);
        }
        return res;
    }
}
