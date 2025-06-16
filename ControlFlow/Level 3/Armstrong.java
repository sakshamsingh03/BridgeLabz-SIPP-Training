import java.util.*;
public class Armstrong {

	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	//talking user input
	int n=sc.nextInt();
	int c=0,x=n,sum=0,y=n;
	while(n!=0){
		c++;
		n/=10;
	}
	while(x!=0){
		int a=(x%10);
		sum+=(int)Math.pow(a,c);
		x/=10;
	}
	if(sum==y)
		System.out.println("armstrong no.");
	else
		System.out.println("not a armstrong no.");
	}
}