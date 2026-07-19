package L1;

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0, count=0;
		int arr[]=new int[10];
        System.out.print("URK23CS1064");
		System.out.println("Fill the array with 10 values");
		for(int i=0; i<arr.length;i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
			}
		double avg=(double)sum/arr.length;
		for(int i=0; i<arr.length;i++) {
			if (arr[i]>avg){
				count++;
			}
		}
		System.out.print("Sum: "+ sum);
		System.out.print("\nGreater than average: "+ count);
    }
}
