/**
 * @Author lty
 * @Date 2023/2/1 15:02
 * @Description
 */
public class DecodeMessage {
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        char now = 'a';
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ' && map[key.charAt(i) - 'a'] == 0) {
                map[key.charAt(i) - 'a'] = now;
                now++;
            }
        }
        StringBuilder res = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                res.append(' ');
            } else {
                res.append(map[message.charAt(i) - 'a']);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeMessage().decodeMessage("the quick brown fox jumps over the lazy dog"
                , "vkbs bs t suepuv"));
    }
}
