package com.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
	public static void main(String[] args) {
        try {
           Scanner sc = new Scanner(System.in);
           int number1 = sc.nextInt();
           int number2 = sc.nextInt();
           System.out.println(number1/number2);
        		   
           sc.close();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught");
        }catch(InputMismatchException e) {
        	System.out.println("InputMismatchException caught");
        }
    }
}
