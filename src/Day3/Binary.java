package Day3;

import java.util.Scanner;

public class Binary {
	
	static String decToBin(int n){
		String bin = "";
		while(n!=0){
			int r = n%2;
			bin = r+bin;
			n = n/2;
		}
		return bin;
	}
	
	static int dec(int n){
		int i = 0, dec=0;
		while(n!=0){
			int r = n%10;
			dec = (int) (dec+r*Math.pow(2, i));
			n = n/10;
			i++;
		}
		return dec;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the decimal vlaue");
		int decimal = in.nextInt();
		System.out.println(decToBin(decimal));
		String s = decToBin(decimal);
		String s1 = "", s2 = "";
		
		while(s.length()!=8){
			s = 0+s;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(i<4)
				s1 = s1+ch;
			else
				s2 = s2+ch;
		}
		s = s2+s1;
		System.out.println(s);
		int bin = Integer.parseInt(s);
		System.out.println(dec(bin));
		in.close();
	}

}
