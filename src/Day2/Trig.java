package Day2;

import java.util.Scanner;

public class Trig {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double degree = in.nextDouble();
		double radian = Math.toRadians(degree);
		double sin = Math.sin(radian);
		double cos = Math.cos(radian);
		System.out.println(sin+"  "+cos);
		in.close();
	}

}
