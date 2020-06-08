package Day3;

import java.util.Scanner;

public class RangedPrime {
	
	static boolean isprime(int n){
		int i =2;
		while(i<=n/2){
			if(n%i == 0)
				return false;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		
		for(int i = m; i<= n; i++){
			if(isprime(i))
				System.out.println(i);
		}
		in.close();
	}

}
