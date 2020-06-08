package Day10;

import com.bridgelabz.blzlib.MathFunction;
import com.bridgelabz.blzlib.StringFunctions;

public class PrimePalin {

	public static void main(String[] args) {
		Object[][] a = new Object[10][100];
		Object[][] a1 = new Object[10][100];
		int m = 0, n = 0;
		int prime = 1;
		for(int i = 0; i < 10; i++){
			for(int j = 0 ; j < 100; j++){
				if(MathFunction.isPrime(prime))
					a[i][j] = prime;
				else
					a[i][j] = "";
				prime++;
			}

			for(int j = 0 ; j < 100; j++){
				String s = a[i][j].toString();
				if(StringFunctions.isPalindrome(s) && s!=""){
					a1[m][n++] = s;
				}
			}
			m++;
		}
		
		for (Object[] objects : a1) {
			for (Object object : objects) {
			if(object != null)//important
					System.out.print(object+" ");
			}
			System.out.println();
		}

	}
}


