package Day8;

import java.util.Scanner;

public class InsertionSort {
	
	public static String[] getArr() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of array elements");
		int n = in.nextInt();
		System.out.println("Enter "+n+" array elements");
		String[] s = new String[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = in.next();
		}
		in.close();
		return s;
	}
	
	public static void dispArr(String[] s){
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
		System.out.println();
	}
	
	public static void insertionSort(String[] s){
		
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

	public static void main(String[] args) {
		String[] s = getArr();
		insertionSort(s);
		dispArr(s);
	}

}
