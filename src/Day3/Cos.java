package Day3;

import java.util.Scanner;

public class Cos {
	
	static int fact(int n){
		int fact = 1, i = 2;
		while(i<=n){
			fact = fact*i;
			i++;
		}
		return fact;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of x");
		double x = in.nextDouble();
		System.out.println("Enter the value of n");
		int n = in.nextInt();
		x = x % (2*Math.PI);
		double cosx = 1;
		int i = 2, k = 0;
		
		while(k<n){
			if(n%2 == 0)
				cosx = cosx-(Math.pow(x, i)/fact(i));
			else
				cosx = cosx+(Math.pow(x, i)/fact(i));
			k++;
			i = i+2;
		}
		System.out.println(cosx);
		in.close();
	}

}
