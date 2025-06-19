import java.util.*;
class CompareStrings{
public static void main(String... arg){
Scanner sc=new Scanner(System.in);
System.out.println("enter both string of equal length: ");
String s1=sc.next();
String s2=sc.next();
if(charMethod(s1,s2) && equalMethod(s1,s2))
	System.out.println("both are equal");
else
	System.out.println("both are not equal");
}
static boolean charMethod(String s,String s1){
	int a=0;
	for(int i=0;i<s.length();i++){
		if(s.charAt(i)==s1.charAt(i))
			a++;
	}
	return a==s.length();
}
static boolean equalMethod(String s,String s1){
	return s.equals(s1);
}
}