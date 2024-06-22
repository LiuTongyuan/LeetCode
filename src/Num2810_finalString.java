/**
 * @Author lty
 * @Date 2024/4/1 15:44
 * @Description
 */
public class Num2810_finalString {
    public String finalString(String s) {
        boolean re = false;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }
}
