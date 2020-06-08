package Day8;

import java.util.Scanner;

public class MagicNumber {
	
	public static int pow(int n , int p){
		int pow = 1;
		while(p>0){
			pow = pow*n;
			p--;
		}
		return pow;
	}
	
	public static int middle(int l, int h){
		int mid = (l+h)/2;
		return mid;
	}
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the range of values in the form of 2^n");
		int n = in.nextInt();
		int[] a = new int[pow(2,n)];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		System.out.println("Guess the numbers between "+a[0]+" to "+a[a.length-1]);
		
		int l = 0, h = a.length-1, mid = (l+h)/2;
		String ans = "";
		String val = "";
		
		while(true){
			System.out.println("Is your element is "+a[mid]+" if yes press Y else N");
			ans = in.next();
			if(ans.equals("Y")){
				System.out.println("Final answer is "+a[mid]);
				return;
			}
			System.out.println("Whether the element is greater than present value or less than that");
			System.out.println("If greater then press G else L");
			val = in.next();
			if(val.equals("G")){
				l = mid+1;
				mid = middle(l, h);
			}
			else{
				h = mid-1;
				mid = middle(l, h);
			}
			if(l>h){
				System.out.println("Selected element not present within the range ");
				return;
			}
		}
	}
}
