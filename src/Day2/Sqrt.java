package Day2;

import java.util.Scanner;

public class Sqrt {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double c = in.nextDouble();
		double epsilon = 1e-15;
		double t = c;
		while(Math.abs(t-c/t)>epsilon*t){
			t = (c/t+t)/2.0;
		}
		System.out.println(t);
		in.close();
	}

}
