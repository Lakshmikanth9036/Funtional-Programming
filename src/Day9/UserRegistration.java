package Day9;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the First Name and Last Name");
		String fullname = in.nextLine();
		boolean name = Pattern.compile("[a-zA-z ]+").matcher(fullname).matches();
		if(!name){
			System.out.println("No Numbers and special characters are allowed");
			return;
		}
		
		System.out.println("Enter your email address");
		String email = in.next();
		boolean mail = Pattern.compile("(.+)@(.+)").matcher(email).matches();
		if(!mail){
			System.out.println("enter valid email address");
			return;
		}
		
		System.out.println("Enter your mobile number");
		String phoneNO = in.next();
		boolean no = Pattern.compile("91-[6789]{1}[0-9]{9}").matcher(phoneNO).matches();
		if(!no){
			System.out.println("Enter Phone Number with Valid Country Code");
			return;
		}
		
		System.out.println("Enter the User Id");
		String userId = in.next();
		boolean id = Pattern.compile("[a-zA-z]+").matcher(userId).matches();
		if(!id){
			System.out.println("No Numbers and special characters are allowed");
			return;
		}
		
		System.out.println("Enter the password");
		String password = in.next();
		boolean psswrd = Pattern.compile("((?=.*[a-z])(?=.*d)([@#$%])(?=.*[A-Z]).{8,15})").matcher(password).matches();
		if(!psswrd){
			System.out.println(" Password is min 8 Chars with at least one Uppercase, has exactly one special character and has at least one numeric number in password");
			return;
		}
		
		in.close();
	}

}
