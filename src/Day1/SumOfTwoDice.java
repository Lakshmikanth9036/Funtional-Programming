package Day1;

import java.util.Random;

public class SumOfTwoDice {

	public static void main(String[] args) {
		Random rand = new Random();
		int sum = 0;
		for(int i = 0 ; i < 2 ; i++){
			sum = sum+rand.nextInt(6)+1;
		}
		System.out.println(sum);
	}

}
