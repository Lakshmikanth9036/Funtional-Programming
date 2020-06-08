package com.bridgelabz.blzlib;

public class MathFunction {
	
	public static double pow(double n , int p){
		double pow = 1;
		while(p>0){
			pow = pow*n;
			p--;
		}
		return pow;
	}

	public static double harmonic(double n){
		double i=2;
		double k = 1;
		while(i<=n){
			k = k+1/i;
			i++;
		}
		return k;
	}
	
	public static double sine(double degree){
		degree = Math.toRadians(degree);
		double sin = Math.sin(degree);
		return sin;
	}

	public static double cose(double degree){
		degree = Math.toRadians(degree);
		double cos = Math.cos(degree);
		return cos;
	}
	
	public static int binary(int n){
		String bin = "";
		while(n!=0){
			int r = n%2;
			bin = r+bin;
			n = n/2;
		}
		return Integer.parseInt(bin);
	}
	
	public static double sqrt(double c){
		double epsilon = 1e-15;
		double t = c;
		while(Math.abs(t-c/t)>epsilon*t){
			t = (c/t+t)/2.0;
		}
		return c;
	}
	
	public static double sqrt(double c, double epsilon){
		double t = c;
		while(Math.abs(t-c/t)>epsilon*t){
			t = (c/t+t)/2.0;
		}
		return c;
	}
	
	public static boolean isPrime(int n){
		int i = 2;
		while(i<=n/2){
			if(n%i == 0)
				return false;
			i++;
		}
		return true;
	}
	
	public static long fact(int n){
		int fact = 1, i = 2;
		while(i<=n){
			fact = fact*i;
			i++;
		}
		return fact;
	}
	
	public static int minValue(int[] a){
		int smallest = a[0];
		for (int i = 1; i < a.length; i++) {
			if(smallest>a[i])
				smallest = a[i];
		}
		return smallest;
	}
	
	public static int maxValue(int[] a){
		int biggest = a[0];
		for (int i = 1; i < a.length; i++) {
			if(biggest<a[i])
				biggest = a[i];
		}
		return biggest;
	}
	
	public static String minValue(String[] s){
		String min = s[0];
		for (int i = 1; i < s.length; i++) {
			if(min.compareTo(s[i])>0)
				min = s[i];
		}
		return min;
	}
	
	public static String maxValue(String[] s){
		String max = s[0];
		for (int i = 1; i < s.length; i++) {
			if(max.compareTo(s[i])<0)
				max = s[i];
		}
		return max;
	}
	
	public static double futureVlaue(double c, double r, int t){
		double futureValue = c*(pow(1+r, t));
		return futureValue;
	}
	
	public static double presentValue(double c, double r, int t){
		double presentValue = c/(pow(1+r, t));
		return presentValue;
	}

	public static boolean checkCollinearUsingSlope(int x1,int y1,int x2,int y2,int x3,int y3){
		int slop1 = (y2-y1)/(x2-x1);
		int slop2 = (y3-y2)/(x3-x2);
		int slop3 = (y3-y1)/(x3-x1);
		if(slop1 == slop2 && slop1 == slop3)
			return true;
		return false;
	}
	
	public static boolean checkCollinearUsingArea(int x1,int y1,int x2,int y2,int x3,int y3){
		int a = x1-x2, b = x2-x3, c = y1-y2, d = y2-y3;
		double collinear = (1.0/2.0)*(a*d-b*c);
		if(collinear == 0)
			return true;
		return false;
	}
}
