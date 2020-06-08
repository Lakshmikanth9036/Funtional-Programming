package Day3;

import java.util.Scanner;

public class DupEle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i<n ; i++){
			a[i] = in.nextInt();
		}
		
		int[] dup = new int[a.length];
		int k = 0;
		int len = a.length;
		for(int i = 0 ; i<len ;i++){
			int count = 0;
			for(int j = i+1 ; j<len; j++){
				if(a[i] == a[j]){
					a[j] = a[len-1];
					j--;
					len--;
					count++;
				}
			}
			if(count > 0)
				dup[k++] = a[i];
		}
		
		int[] dupli = new int[k];
		for(int i = 0 ; i<k ; i++){
			dupli[i] = dup[i];
		}
		
		for (int i = 0; i < dupli.length; i++) {
			System.out.print(dupli[i]+" ");
		}
		
		in.close();
	}

}
