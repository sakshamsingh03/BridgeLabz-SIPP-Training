import java.util.Scanner;

class Discountstudentfee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double feeinput, inputDiscountPercent;
        System.out.print("Enter student fee: ");
        feeinput = input.nextDouble();

        System.out.print("Enter discount percentage: ");
        inputDiscountPercent = input.nextDouble();

        double discountinput = (feeinput * inputDiscountPercent) / 100.0;
        double finalFee = feeinput - discountinput;

        System.out.println("The discount amount is INR " + discountinput + " and final discounted fee is INR " + finalFee);

        input.close(); 
    }
}
