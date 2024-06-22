package SlidingWindow.NoDefineLen;

/**
 * @Author lty
 * @Date 2023/12/30 19:48
 * @Description 2024. 考试的最大困扰度 1643
 */
public class Num2024_maxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int left = 0, right = 0;
        int countT = 0, countF = 0;
        int maxLen = 0;
        while (right < chars.length) {
            if (chars[right] == 'T') {
                countT++;
            } else {
                countF++;
            }
            right++;
            while (countT > k && countF > k) {
                if (chars[left] == 'T') {
                    countT--;
                } else {
                    countF--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);

        }
        return maxLen;

    }
}
