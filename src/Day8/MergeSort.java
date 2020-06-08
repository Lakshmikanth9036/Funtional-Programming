package Day8;

import java.util.Scanner;

public class MergeSort {
	
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
	
	public static void mergSort(String[] s, int l, int h){
		if(l<h){
			int m = (l+h)/2;
			mergSort(s, l, m);
			mergSort(s, m+1, h);
			merge(s,l,m,h);
		}
	}
	
	public static void merge(String[] s, int l, int m, int h){
		String[] b = new String[h-l+1];
		int k = 0, i = l, j = m+1;
		while(i<=m && j<=h){
			if(s[i].compareTo(s[j])<0)
				b[k++] = s[i++];
			else
				b[k++] = s[j++];
		}
		while(i<=m)
			b[k++] = s[i++];
		while(j<=h)
			b[k++] = s[j++];
		for (int i1 = 0; i1 < b.length; i1++) {
			s[l+i1] = b[i1];
		}
	}

	public static void main(String[] args) {
		String[] s = getArr();
		mergSort(s, 0, s.length-1);
		dispArr(s);
	}
}
