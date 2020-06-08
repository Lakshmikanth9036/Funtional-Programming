package Day10;

import com.bridgelabz.blzlib.MathFunction;

public class Prime {

	public static void main(String[] args) {
		Object[][] a = new Object[10][100];
		int prime = 1;
		for(int i = 0; i < 10; i++){
			for(int j = 0 ; j < 100; j++){
				if(MathFunction.isPrime(prime))
					a[i][j] = prime;
				else
					a[i][j] = "";
				prime++;
				
			}
		}
		for(Object[] x : a){
			for(Object val : x){
				if(!val.equals(""))
					System.out.print(val+" ");
			}
			System.out.println();
		}
	}

}
