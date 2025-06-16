import java.util.*;
class LeapYearCheckSingleLine{
public static void main(String... arg){
Scanner sc=new Scanner(System.in);
System.out.print("Enter a year (>= 1582): ");
int year = sc.nextInt();
if(year >1582 && (year%4==0) && ((year%100!=0) || (year%400==0)))
System.out.print(year+" is a Leap Year.");
else
System.out.print(year+" is not a Leap Year.");
}
}