package Day10;

import java.util.Scanner;

public class ArrayOperation {

	public static int[][] getArr() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the row size");		
		int m = in.nextInt();
		System.out.println("Enter the column size");
		int n = in.nextInt();
		int[][] a = new int[m][n];
		System.out.println("Enter the "+m+"x"+n+" matrix");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = in.nextInt();
			}
		}
		return a;
	}
	
	public static void dispArr(int[][] a){
		for(int[] arr:a){
			for (int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	static char c;
	public static void main(String[] args) {
//		int[][] a = getArr();
//		System.out.println(a.length);
//		dispArr(a);
		char c1 = '\u0000';
		System.out.println(c==c1);
	}
		
	
}
