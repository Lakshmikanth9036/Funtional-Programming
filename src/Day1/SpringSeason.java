package Day1;

import java.util.Scanner;

public class SpringSeason {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int d = in.nextInt();
		if(m>=3 && m<=6){
			if(m == 3 && d>=20)
				System.out.println(true);
			else if(m==6 && d<=20)
				System.out.println(true);
			else if(m>3 && m<6 )
				System.out.println(true);
			else
				System.out.println(false);
		}
		else
			System.out.println(false);
		in.close();
	}

}
