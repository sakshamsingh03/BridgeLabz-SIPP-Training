class Discountedfee{
public static void main(String[] args){
		 int fee = 125000;
        int percentdiscount = 10;
        double discount = (fee * percentdiscount) / 100.0;
        double discountedFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountedFee);
}
}