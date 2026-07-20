package L1;
import java.util.Scanner;
public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("URK23CS1064");
        System.out.print("Enter the Number: ");
        int n = sc.nextInt();
        int temp = n;
        int count = 0;
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n = n / 10;
        }
        System.out.println("Digits are:");
        for (int i = 0; i < count; i++) {
            System.out.println(digits[i]);
        }
        sc.close();
    }
}
