package Day2;

public class Stats5 {

	public static void main(String[] args) {
		int i = 0;
		double avg = 0, min = 0, max = 0;
		while(i<5){
			double val = Math.random();
			System.out.println(val);
			avg = avg+val;
			if(i==0)
				min = val;
			double m = Math.min(min, val);
			min=m;
			
			max = Math.max(max, val);
			i++;
		}
		System.out.println(avg/5+" "+min+" "+max);
	}

}
