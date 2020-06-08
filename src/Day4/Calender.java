package Day4;

import java.util.Scanner;

public class Calender {
	
	static int getDay(int m, int d, int y){
		int yo = y-(14-m)/12;
		int x = yo+yo/4-yo/100+yo/400;
		int mo = m+12*((14-m)/12)-2;
		int d0 = (d+x+31*mo/12)%7;
		return d0;
		}
	
	static boolean isLeapYear(int year){
		if(year%400 == 0)
			return true;
		else if(year%100 == 0)
			return false;
		else if(year%4 == 0)
			return true;
		return false;
	}
	

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the month");
		int m = in.nextInt();
		System.out.println("Enter the year");
		int y = in.nextInt();
		
		int day = getDay(m, 1, y);	
		
		String[] months = {"", "January", "February", "March",
	            			"April", "May", "June",
	            			"July", "August", "September",
	            			"October", "November", "December"};
		int[] days = {0 , 31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};
		String[] week = {"S " , "M " , "T " , "W " , "Th" , "F " , "S "};
		
		System.out.println(months[m]+" "+y);
		
		for(int i=0 ; i<week.length; i++){
			System.out.print(week[i]+" ");
		}
		System.out.println();
		
		if(isLeapYear(y) && m==2){
			days[m] = 29;
		}
		
		for(int i = 0 ; i<day ; i++){
			System.out.print("   ");
		}
		
		for(int i=1 ; i<=days[m] ; i++){
				System.out.print(i+" ");
			if(i<10)
				System.out.print(" ");
			if((i+day)%7 == 0)
				System.out.println();
		}
		in.close();
	}

}
