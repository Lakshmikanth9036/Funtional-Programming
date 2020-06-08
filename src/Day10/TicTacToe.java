package Day10;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	public static void place(char[][] c, int m, int n,char p){
		c[m][n] = p;
	}
	
	public static boolean check(char[][] board, int m, int n) {
		if(board[m][n] != '\u0000')
			return false;
		else
			return true;
	}
	
	public static boolean win(char[][] b, char c) {
		if(b[0][0] == b[0][1] && b[0][0] == b[0][2] && b[0][0] == c)
			return true;
		else if(b[1][0] == b[1][1] && b[1][0] == b[1][2] && b[1][0] == c)
			return true;
		else if(b[2][0] == b[2][1] && b[2][0] == b[2][2] && b[2][0] == c)
			return true;
		else if(b[0][0] == b[1][0] && b[0][0] == b[2][0] && b[0][0] == c)
			return true;
		else if(b[0][1] == b[1][1] && b[0][1] == b[2][1] && b[0][1] == c)
			return true;
		else if(b[0][2] == b[1][2] && b[0][2] == b[2][2] && b[0][2] == c)
			return true;
		else if(b[0][0] == b[1][1] && b[0][0] == b[2][2] && b[0][0] == c)
			return true;
		else if(b[0][2] == b[1][1] && b[0][2] == b[2][0] && b[0][2] == c)
			return true;
		return false;
	}
	
	public static void dispBoard(char[][] b) {
		for (char[] x:b) {
			for (char c : x) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		char[][] board = new char[3][3];
		
		int m=0,n=0, count = 9;
		while(true){
			boolean res = false;
			
			if(count == 0){
				System.out.println("Board is full");
				break;
			}
			
			while(res==false){
				System.out.println("Enter the row and colomn");
				m = in.nextInt();
				n = in.nextInt();
				res = check(board,m,n);
				if(res == false)
					System.out.println("That place is already been occupied pick another place");
			}
			place(board,m,n,'X');
			dispBoard(board);
			count--;
			boolean win = win(board,'X');
			if(win){
				System.out.println("You won");
				break;
			}
			boolean res1 = false;
			
			if(count == 0){
				System.out.println("Board is full");
				break;
			}
			
			while(res1==false){
				System.out.println("Enter the row and colomn");
				m = rand.nextInt(3);
				n = rand.nextInt(3);
				res1 = check(board,m,n);
				if(res1 == false)
					System.out.println("That place is already been occupied pick another place");
			}
			place(board,m,n,'O');
			dispBoard(board);
			count--;
			boolean win1 = win(board,'O');
			if(win1){
				System.out.println("You won");
				break;
			}
		}
		in.close();
	}
}
