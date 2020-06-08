package Day2;

import java.util.Scanner;

public class FlipCoin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i = 0;
		int head = 0, tail = 0;
		while (i<n){
			if(Math.random()>0.5)
				head++;
			else
				tail++;
			i++;
		}
		double hper = (head*100.0)/n;
		double tper = (tail*100.0)/n;
		System.out.println(hper+" "+tper);
		in.close();
	}

}
