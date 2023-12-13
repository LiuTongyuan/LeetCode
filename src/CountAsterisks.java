/**
 * @Author lty
 * @Date 2023/1/31 15:35
 * @Description
 */
public class CountAsterisks {
    public int countAsterisks(String s) {
        boolean in = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                in = !in;
            } else if (s.charAt(i) == '*' && (!in)) {
                count++;
            }
        }
        return count;
    }
}
