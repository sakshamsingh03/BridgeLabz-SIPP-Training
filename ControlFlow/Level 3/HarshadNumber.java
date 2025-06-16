import java.util.Scanner;

public class HarshadNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int sum=0,c=0,x=n;
		while(n!=0){
			sum+=n%10;
			n/=10;
		}
		if(x%sum==0)
			System.out.print("Harshad number");
		else
			System.out.print("not a Harshad number");
	}
}