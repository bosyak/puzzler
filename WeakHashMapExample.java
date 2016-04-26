import javax.swing.*;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Andrey Panov on 07.04.2016
 */
public class WeakHashMapExample {
    public WeakHashMapExample() {
        Map<Object, String> map = new WeakHashMap<>();

        if (System.currentTimeMillis() > 0) {
            String data = new String("some text");
            map.put(data, "");
            String data2 = "text some";
            map.put(data2, "");
        }
        System.gc();

        Object[] options = {"Zero", "One", "Two"};

        int res = JOptionPane.showOptionDialog(null, "How many elements in map?", "Question",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

        if (res == 0 && map.isEmpty()) {
            System.out.println("YES!");
            System.exit(0);
        }
        if (res == 1 && map.size() == 1) {
            System.out.println("YES!");
            System.exit(0);
        }
        if (res == 2 && map.size() == 2) {
            System.out.println("YES!");
            System.exit(0);
        }

        System.out.println("No... Another variant :)");
    }

    public static void main(String[] args) {
        new WeakHashMapExample();
    }
}