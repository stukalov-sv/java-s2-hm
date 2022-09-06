/*
 * Напишите программу, записывающую 100 раз слово ”ТЕST” в файл. 
 * Слова должны чередоваться по формату – четная итерация большими буквами, нечетные – маленькими
 * Пример: TESTtestTESTtestTEST…
 */

import java.io.FileWriter;
import java.util.logging.Logger;

public class Task1HM {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        String content = "TEXT";
        try {
            FileWriter write = new FileWriter("result1HM.txt", true);
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    write.write(content);
                } else {
                    write.write(content.toLowerCase());
                }
            }
            write.flush();
            write.close();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        } 
    }
}
