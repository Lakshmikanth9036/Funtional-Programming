package Day4;

import java.util.Scanner;

public class StringFunctions {
	
	static int[] frequency(String s){
		int[] count = new int[26];
		for(int i = 0 ; i<s.length(); i++){
			char ch = s.charAt(i);
			if(ch>='A' && ch<='Z')
				count[ch-65]++;
			else if(ch>='a' && ch<='z')
				count[ch-97]++;
		}
		return count;
	}
	
	static boolean isAnagram(String s1, String s2){
		int[] s1c = frequency(s1);
		int[] s2c = frequency(s2);
		for(int i = 0 ; i <26 ; i++ ){
			if(s1c[i] != s2c[i])
				return false;
		}
		return true;
	}
	
	static boolean isPalindrome(String s){
		int l = 0 , r = s.length()-1;
		while(l<r){
			if(s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of first string");
//		String s1 = in.nextLine();
//		System.out.println("Enter the value of second string");
//		String s2 = in.nextLine();
//		boolean res = isAnagram(s1, s2);
//		if(res)
//			System.out.println("Anagram");
//		else
//			System.out.println("Not a anagram");
		String s = in.next();
		boolean res = isPalindrome(s);
		if(res)
			System.out.println("Palindrome");
		else
			System.out.println("Not a palindrome");
		
		
		in.close();
	}

}
