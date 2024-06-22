/**
 * @Author lty
 * @Date 2024/1/1 13:42
 * @Description 1599. 经营摩天轮的最大利润 1548
 */
public class Num1599_minOperationsMaxProfit {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        if (4 * boardingCost - runningCost <= 0) {
            return -1;
        }
        int waiting = 0, maxProfit = 0, res = -1, on = 0, profit = 0;
        for (int i = 0; i < customers.length; i++) {
            waiting += customers[i];
            on = Math.min(4, waiting);
            waiting -= on;
            profit += on * boardingCost - runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                res = i + 1;
            }
        }
        profit += waiting / 4 * 4 * boardingCost - waiting / 4 * runningCost;
        if (profit > maxProfit) {
            res = customers.length + waiting / 4;
        }
        if (waiting % 4 * boardingCost - runningCost > 0){
            res++;
        }

        return res;
    }
}
