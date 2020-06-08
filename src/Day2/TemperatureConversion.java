package Day2;

import java.util.Scanner;

public class TemperatureConversion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double t = in.nextDouble();
		double f = t * (9/5) +32;
		double c = (t-32)*(5/9);
		System.out.println(c+ " "+f);
		in.close();
	}

}
