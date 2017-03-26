import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by sjy_1993 on 2017/3/6.
 */
public class Test {

        public static void main(String[] args) {
            char[] a1 = {'A', 'B', 'C'};
            try {
                File file = new File("D:\\Modul1.txt");
                FileWriter fw = new FileWriter(file);
                fw.write(a1);
                fw.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
}
