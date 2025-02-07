import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            int num = sc.nextInt();
            if (isArmstrong(num)) {
                System.out.println(num + " is an Armstrong number.");
            } else {
                System.out.println(num + " is not an Armstrong number.");
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int numDigits = String.valueOf(num).length();
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, numDigits);
            num /= 10;
        }
        return sum == originalNum;
    }
}
