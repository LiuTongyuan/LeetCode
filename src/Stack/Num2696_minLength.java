package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author lty
 * @Date 2024/1/10 10:03
 * @Description 2696. 删除子串后的字符串最小长度
 */
public class Num2696_minLength {
    public int minLength(String s) {
        Deque<Character> characters = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!characters.isEmpty()) {

                if ((c == 'B' || c == 'D') && c - characters.peek() == 1) {
                    characters.pop();
                    continue;
                }
            }
            characters.push(c);
        }
        return characters.size();
    }
}
