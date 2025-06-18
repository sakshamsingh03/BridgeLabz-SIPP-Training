import java.util.*;
class generateException{
public static void main(String... arg){
String text=null;
generateException(text);
}
static void generateException(String s){
try{
s.charAt(0);
}
catch(NullPointerException ne){
System.out.println("exception caught "+ne.getMessage());
}
finally{
System.out.println("finally");
}
}
}