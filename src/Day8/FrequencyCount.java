package Day8;

import java.util.Arrays;
import java.util.Scanner;

public class FrequencyCount {
	
	public static int count(String s){
		int count = 0;
		for(int i = 0; i<s.length(); i++){
			while( i<s.length() && s.charAt(i) != ' '){
				i++;
			}
			count++;
		}
		return count;
	}
	
	public static String[] split(String s) {
		int count = count(s);
		String[] str = new String[count];
		int k = 0;
		for(int i = 0; i<s.length(); i++){
			String s1 = "";
			while(i<s.length() && s.charAt(i) != ' '){
				s1 = s1+s.charAt(i);
				i++;
			}
			str[k++] = s1;
		}
		return str;
	}
	
	public static void sort(String[] s){
		
		for(int i = 1 ; i < s.length ; i++){
			int j = i-1;
			String temp = s[i];
			while(j>=0 && temp.compareTo(s[j])<0){
				s[j+1] = s[j];
				j--;
			}
			s[++j] = temp;
		}
	}

	public static void frequency(String[] str){
		
		for (int i = 0; i < str.length; i++) {
			int count = 1;
			for (int j = i+1; j < str.length; j++) {
				if(i<str.length && str[i].equals(str[j])){
					count++;
					i++;
				}
			}
			System.out.println(str[i]+" "+count);
		}
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = in.nextLine();
		String[] str = split(s);
		System.out.println(Arrays.toString(str));
		sort(str);
		System.out.println(Arrays.toString(str));
		frequency(str);
		in.close();
	}
}
