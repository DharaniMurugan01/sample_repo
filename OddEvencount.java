import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OddEvencount {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            int odd = 0, even = 0;

            for (int i = 0; i < size; i++) {
                if (arr[i] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            System.out.println("Odd count: " + odd);
            System.out.println("Even count: " + even);
            sc.close();
        } catch (IOException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
}
