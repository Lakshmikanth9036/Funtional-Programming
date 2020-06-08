package Day2;

import java.util.Scanner;

public class PowerOf2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double pow = Math.pow(2, n);
		int k = 2;
		while(k<=pow){
			System.out.println(k);
			k = k*2;
		}
		in.close();
	}

}
