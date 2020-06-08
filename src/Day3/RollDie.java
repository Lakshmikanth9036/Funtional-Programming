package Day3;

import java.util.Random;
import java.util.Scanner;

public class RollDie {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = in.nextInt();
		int[] count = new int[6];
		while(n>0){
			int val = rand.nextInt(6)+1;
			count[val-1]++;
			n--;
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i]+" ");
		}
		System.out.println();
		
		int k = 1, maxTimes = count[0];
		for (int i = 0; i < count.length; i++) {
			if(maxTimes<count[i]){
				maxTimes = count[i];
				k = i+1;
			}
		}
		
		System.out.println(k+" is the number that had fallen more times "+maxTimes);
		in.close();
	}

}
