import java.util.Scanner;
/*
Scanner utility class that encapsulates getInt, getString method and catch the exception
 */
public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);


    public static int getInt() {
        while (true) {
            try {
                String s = scanner.nextLine();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.err.print("Please enter integer! please try again:");
            }
        }
    }

    public static int getInt(int min, int max) {
        while (true) {
            try {
                String s = scanner.nextLine();
                int value =  Integer.parseInt(s);
                if (value < min || value > max) {
                    System.err.print("invalid input, range:[" + min + "," + max + "],please try again:");
                } else {
                    return value;
                }
            } catch (Exception e) {
                System.err.print("invalid input, range:[" + min + "," + max + "],please try again:");
            }
        }
    }


    public static String getString(){
        while (true) {
            try {
                String s = scanner.nextLine();
                if (s.length() >0){
                    return s;
                }
            } catch (Exception e) {
                System.err.print("Invalid input, please try again:");
            }
        }
    }
}
