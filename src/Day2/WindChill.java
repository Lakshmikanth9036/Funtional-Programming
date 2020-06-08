package Day2;

import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double t = in.nextDouble();
		double v = in.nextDouble();
		if(t<=50 && v>=3 && v<=120){
			double w = 35.74+0.6215*t+(0.4275*t-35.75)*Math.pow(v, 0.16);
			System.out.println(t);
			System.out.println(v);
			System.out.println(w);
		}
		else
			System.out.println("t value should be less than 50 or v value should be greater than 3 and less than 120");
		in.close();
	}

}
