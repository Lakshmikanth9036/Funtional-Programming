package Day2;

import java.util.Scanner;

public class HarmonicNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double i=2;
		double k = 1;
		while(i<=n){
			k = k+1/i;
			i++;
		}
		System.out.println(k);
		in.close();
	}

}
