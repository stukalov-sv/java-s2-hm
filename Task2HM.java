/*
 * Напишите программу, которая считает, распарсит и выведет в логгер 
 * заранее созданный файл с именами, предметами и оценками студентов
 * Формат строк в файле:
 * Андрей 5
 * Алена 5
 * Игорь 4
 * Формат вывода: Ученик %s получил сегодня %d.
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task2HM {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        fileCreator();
        
        try {
            FileReader fr = new FileReader("result2HM.txt");
            Scanner iScanner = new Scanner(fr);
            while (iScanner.hasNextLine()) {
                String[] split = iScanner.nextLine().split(" ");
                System.out.printf("Pupil %s was rated %d", split[0], Integer.valueOf(split[1]));
                System.out.println();
            }
            iScanner.close();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        }

        try {
            File deleteFile = new File("result2HM.txt");
            deleteFile.delete();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        }
    }

    private static void fileCreator() {
        Logger logger = Logger.getAnonymousLogger();

        try(PrintWriter output = new PrintWriter(new FileWriter("result2HM.txt",true))) {
            output.printf("%s\r\n", "Андрей 5");
            output.printf("%s\r\n", "Алена 5");
            output.printf("%s\r\n", "Игорь 4");
            output.flush();
            output.close();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());
        }
    }
}
