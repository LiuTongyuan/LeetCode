import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/10/23 20:13
 * @Description
 */
public class Num2678_CountSeniors {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(s->Integer.parseInt(s.substring(11, 13))>60).count();
    }
}
