package Day8;

import java.util.Scanner;

public class BubbleSort {
	
	public static int[] getArr() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of array elements");
		int n = in.nextInt();
		System.out.println("Enter "+n+" array elements");
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		return a;
	}
	
	public static void dispArr(int[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void bubbleSort(int[] a){
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = getArr();
		dispArr(a);
		bubbleSort(a);
		dispArr(a);
	}
}
