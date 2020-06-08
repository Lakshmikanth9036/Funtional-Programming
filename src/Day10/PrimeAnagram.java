package Day10;
import com.bridgelabz.blzlib.*;

public class PrimeAnagram {

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
				for (int j2 = j+1; j2 < 100; j2++) {
					String s1 = a[i][j].toString();
					String s2 = a[i][j2].toString();
					if(s1.equals("") || s2.equals("")){
						
					}	
					else if(StringFunctions.isAnagram(s1, s2)){
//						System.out.print(s1+"--->"+s2+" ");
//						System.out.println();
						a1[m][n++] = s1;
						a1[m][n++] = s2;
					}
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

