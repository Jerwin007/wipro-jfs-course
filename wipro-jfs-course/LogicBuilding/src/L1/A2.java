package L1;
import java.util.Scanner;
public class A2 {
    public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
        System.out.print("URK23CS1064");
		System.out.print("Enter the Number: ");
		int n=s.nextInt();
		while (n>0) {
			int d=n%10;
			System.out.print(d);
			n=n/10;			
		}
    }
}
