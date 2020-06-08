package Day1;

public class KDW {

	public static void main(String[] args) {
		/*int n = 9, k = 10, m = 13;
		for(int i = 0; i < n; i++){
			for(int j = 0; j<m ; j++){
				if(j==0||j==1||i==n/2 && j<5 || j>=k && j<m-(i*2)  || j>=k && j<k+3)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			if(i<n/2)
				k = k-2;
			else
				k = k+2;
			System.out.println(k);
			System.out.println();
		}*/
		
		
		/*int n = 9, k = 7, m = 13;
		for(int i = 0; i < n; i++){
			for(int j = 0; j<m ; j++){
				if(i==0 && j<n || j==0 || j == 1 || i==n-1 && j<n || i!=0 && i!=n-1 && j==k || i!=0 && i!=n-1 && j==k+1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			if(i<n/2-1)
				k = k+1;
			else if(i>n/2)
				k = k-1;
			System.out.println();
		}*/
		
		
		int n = 9, m = 31;
		for(int i = 0; i < n; i++){
			for(int j = 0; j<m ; j++){
				if(i==j || i+1 == j && i!=n-1 || i==m-(j+1) || i+1 == m-(j+1) && i!=n-1 || i==(m/2+1)-(j+1) && i!=n-1 || i==(m/2+1)-j && i!=0 && i!=n-1 || i+(m/2)==j && i!=0 && i!=n-1 || i+(m/2)-1==j && i!=0 && i!=n-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
			
	}

}
