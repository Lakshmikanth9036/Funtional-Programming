package Day3;

import java.util.Scanner;

public class NthSmallestNthLargest {
	
	static int smallest(int[] a, int n){
		int val = 0;
		for (int i = 0; i < a.length; i++) {
			int count = 0;
			for (int j = 0 ; j < a.length; j++) {
				if(a[i] > a[j])
					count++;
			}
			if(count == n-1)
				val = a[i];
		}
		return val;
	}
	
	static int greatest(int[] a, int n){
		int val = 0;
		for (int i = 0; i < a.length; i++) {
			int count = 0;
			for (int j = 0 ; j < a.length; j++) {
				if(a[i] < a[j])
					count++;
			}
			if(count == n-1)
				val = a[i];
		}
		return val;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i<n ; i++){
			a[i] = in.nextInt();
		}
		System.out.println(smallest(a, 2));
		System.out.println(greatest(a, 2));
		in.close();
	}

}
