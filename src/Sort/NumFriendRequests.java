package Sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author lty
 * @Date 2023/8/15 09:14
 * @Description
 */
public class NumFriendRequests {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        for (int i = 0; i < ages.length; i++) {
            int low = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            low = ages[i] / 2 + 8;
            high = ages[i];
            if(ages[i] < 100){
                high = Math.min(high, 100);
            }

            // ages[y] <= 0.5 * ages[x] + 7
            // ages[y] > ages[x]
            // ages[y] > 100 && ages[x] < 100
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        return 0;
    }
}
