package String;

/**
 * @Author lty
 * @Date 2024/4/13 20:06
 * @Description
 */
public class KMP {
    public static void main(String[] args) {
        fail("ABCABCA");
    }

    public static int[] fail(String s) {
        int[] fail = new int[s.length()];
        char[] str = s.toCharArray();
        for (int i = 1, j = 0; i < s.length(); i++) {
            // j = fail[i - 1];
            while (j != 0 && str[j] != str[i]) {
                j = fail[j - 1];
            }
            if (str[j] == str[i]) {
                j++;
            }
            fail[i] = j;

        }
        return fail;
    }

    public static int KMP(String s, String t) {

        return 0;
    }
}
