package Status;

/**
 * @Author lty
 * @Date 2023/12/27 15:32
 * @Description
 */
public class Num2660_IsWinner {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = getScore(player1);
        int score2 = getScore(player2);
        if (score1 > score2) {
            return 1;
        } else if (score1 == score2) {
            return 0;
        } else {
            return 2;
        }
    }


    public int getScore(int[] player) {
        int sum = player[0];
        sum += player.length > 1 ? (player[0] == 10 ? 2 * player[1] : player[1]) : 0;
        for (int i = 2; i < player.length; i++) {
            boolean dob = player[i - 1] == 10 || player[i - 2] == 10;
            sum += dob ? 2 * player[i] : player[i];
        }
        return sum;
    }

    /**
     * 优化：记录状态
     */

    public int getScoreBetter(int[] player) {
        int ace = 0, sum = 0;
        for (int i = 0; i < player.length; i++) {
            sum += ace > 0 ? 2 * player[i] : player[i];
            ace--;
            if (player[i] == 10) {
                ace = 2;
            }
        }
        return sum;
    }


}
