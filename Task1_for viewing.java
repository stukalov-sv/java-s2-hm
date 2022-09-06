/*
 * Посчитайте сколько драгоценных камней в куче обычных камней.
 * jew = "aB", stones = "aaaAbbbB", res = "a3B1"
 */

import java.util.Scanner;
import java.util.logging.Logger;

public class Task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Enter string of 2 jewels: ");
        String jewels = iScanner.nextLine();
        System.out.printf("Enter string of stones: ");
        String stones = iScanner.nextLine();
        Logger logger = Logger.getAnonymousLogger();
        logger.info(jewFind(jewels, stones));
        iScanner.close();
    }

    private static String jewFind(String jewels, String stones) {
        // Решение преподавателя:
        // int counter;
        // StringBuilder sb = new StringBuilder();
        // for(char c1: jewels.toCharArray()){
        //     counter = 0;
        //     for(char c2: stones.toCharArray()){
        //         if (c1 == c2){
        //             counter++;
        //         }
        //     }
        //     sb.append(c1).append(counter);
        // }
        // return sb.toString();      
        
        int countFirstJew = 0;
        int countSecondJew = 0;

        for (char item : stones.toCharArray()) {
            if (item == jewels.toCharArray()[0]) {
                countFirstJew += 1;
            } else if (item == jewels.toCharArray()[1]) {
                countSecondJew += 1;
            }
        }

        StringBuffer sBuffer = new StringBuffer(jewels);
        sBuffer.insert(1, countFirstJew);
        sBuffer.insert(3, countSecondJew);
        return sBuffer.toString();
    }
}
