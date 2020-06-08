package Day1;

import java.util.Scanner;

public class Quadratic {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the vlaue of a, b and c");
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		double root1 = 0,root2 = 0;
		double delta = (b*b) - (4*a*c);
		if(delta>0){
			root1 = (-b + Math.sqrt(delta))/(2*a);
			root2 = (-b - Math.sqrt(delta))/(2*a);
			System.out.println("First root is: "+root1+"\nSecond root is: "+root2);
		}
		else if(delta == 0){
			root1 = root2 = -b/(2*a);
			System.out.println("First root is: "+root1+"\nSecond root is: "+root2);
		}
		else{
			root1 = -b/(2*a);
			root2 = Math.sqrt(-delta)/(2*a);
			System.out.printf("root1 = %.2f+%.2fi and root2 = %.2f-%.2fi",root1,root2,root1,root2);
		}
		
		in.close();
	}

}
