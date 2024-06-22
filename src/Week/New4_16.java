package Week;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author lty
 * @Date 2024/4/16 13:24
 * @Description
 */
public class New4_16 {
    /**
     * TODO：
     */


    public static int one(int[] nums) {
        return 0;
    }




    public static int three(int[] a, int[] b, int[] c) {
        long[] temp = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i] + b[i];
        }
        Arrays.sort(c);
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0, j = 0; i < c.length && j < temp.length; ) {
            if (temp[i] == c[j]) {
                count++;
            } else if (temp[i] < c[j]) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}
