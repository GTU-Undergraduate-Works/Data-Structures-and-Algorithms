import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * wrapper class to test Main class
 *
 * @author Efkan Durakli
 */
public class MainWrapper {

    private static String TEST_FILE1 = "TestFiles/scenario1";
    private static String TEST_FILE2 = "TestFiles/scenario2";

    public static void main(String[] args) throws IOException {


        System.out.println("Press 1 to test Scenario1.");
        System.out.println("Press 2 to test Scenario2.");
        FileInputStream is;
        boolean flag = false;
        int number = 0;
        Scanner input = new Scanner(System.in);
        try {
            while (!flag) {
                number = Integer.parseInt(input.nextLine());
                if (number == 1) {
                    is = new FileInputStream(new File(TEST_FILE1));
                    System.setIn(is);
                    flag = true;
                }
                else if (number == 2) {
                    is = new FileInputStream(new File(TEST_FILE2));
                    System.setIn(is);
                    flag = true;
                }
                else {
                    System.out.println("Wrong choice.Press again:");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Input is not a number");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.main(args);
    }
}