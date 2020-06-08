package Day3;

import java.util.Scanner;

public class PrimeFactorization {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = in.nextInt();
		for(int i = 2 ; i<=n ; i++){
			if(n%i == 0){
			while(n%i == 0)
				n = n/i;
			System.out.print(i+" ");
			}
		}
		in.close();
	}

}
