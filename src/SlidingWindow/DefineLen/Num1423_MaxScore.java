package SlidingWindow.DefineLen;

/**
 * @Author lty
 * @Date 2023/12/27 19:34
 * @Description 1423. 可获得的最大点数
 */
public class Num1423_MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        int score = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            score += cardPoints[i];
        }
        int maxScore = score;
        for (int i = 0; i < k; i++) {
            score += cardPoints[i] - cardPoints[cardPoints.length - k + i];
            maxScore = Math.max(score, maxScore);
        }
        return maxScore;

    }
}
