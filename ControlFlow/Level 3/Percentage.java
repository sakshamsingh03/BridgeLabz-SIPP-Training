import java.util.*;
class Percentage {
public static void main(String... arg){
Scanner sc=new Scanner(System.in);
System.out.print("Enter physics marks ");
int Physics = sc.nextInt();
System.out.print("Enter chemistry marks ");
int Chemistry = sc.nextInt();
System.out.print("Enter Maths marks ");
int Maths = sc.nextInt();
int avg=(Physics+Chemistry+Maths)/3;
if(avg>=80)
System.out.println("Level 4, above agency-normalized standard");
else if(avg>=70 && avg<80)
System.out.println("Level 3, at agency-normalized standard");
else if(avg>=60 && avg<70)
System.out.println("Level 2, below, approaching agency-normalized standard");
else if(avg>=50 && avg<60)
System.out.println("Level 1, well below agency-normalized standard");
else if(avg>=40 && avg<50)
System.out.println("Level 1, too below agency-normalized standard");
else
System.out.println("Remedial Standard");
}
}