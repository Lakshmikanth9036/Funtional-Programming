package Day2;

import java.util.Scanner;

public class GamlingSimulation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int stake = in.nextInt();
		int goal = in.nextInt();
		int trails = in.nextInt();
		int win = 0, loss = 0;
		
		while(trails>0 && stake <= goal && stake > 0){
			if(Math.random()>0.5){
				stake = stake+1;
				win++;
			}
			
			else{
				stake = stake-1;
				loss++;
			}	
			trails--;
		}
		double winper = (win*100)/(win+loss);
		
		System.out.println(win+" "+winper);
		
		in.close();
		
		
	}

}
