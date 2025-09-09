package com.exceptions;

import java.util.Scanner;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String message) {
		super(message);
	}
}
public class CustomException {
	public static void main(String[] args) {
        try {
        	Scanner sc = new Scanner(System.in);
        	int n = sc.nextInt();
            verifyAge(n); 
        } catch (IllegalArgumentException e) {
        System.out.println("IllegalArgumentException caught");
        }catch(InvalidAgeException e) {
        	System.out.println(e.getMessage());
        }
    }
    public static void verifyAge(int age) throws InvalidAgeException {
        if (age <18) {
            throw new InvalidAgeException("Age should be greater than or equal to 18.");
        }
        System.out.println("Access granted!");
    }

}
