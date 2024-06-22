/**
 * @Author lty
 * @Date 2023/12/13 15:37
 * @Description 2697. 字典序最小回文串 1304
 *
 */
public class Num2697_MakeSmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int len = stringBuilder.length();
        for (int i = 0; i < len / 2; i++) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(len - 1 - i)) {
                if (stringBuilder.charAt(i) < stringBuilder.charAt(len - 1 - i)){
                    stringBuilder.setCharAt(len - 1 - i,stringBuilder.charAt(i));
                }else {
                    stringBuilder.setCharAt(i,stringBuilder.charAt(len - 1 - i));
                }
            }
        }
        return stringBuilder.toString();
    }
}
