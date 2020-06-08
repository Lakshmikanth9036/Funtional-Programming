package cards;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
	
		static Random rand = new  Random();
	
		public static void shuffle(String[] s){
			int n = s.length;
			for(int i = 0 ; i < s.length ; i++ ){
				int idx = rand.nextInt(n-i);
				String temp = s[i];
				s[i] = s[idx];
				s[idx] = temp;
			}
			
		}

		
		static void disp(String[] s){
			for (String string : s) {
				System.out.print(string+" ");
			}
			System.out.println();
		}
		
		static String[] concate(String[] s1, String[] s2){
			String[] s = new String[s1.length+s2.length];
			
			for (int i = 0; i < s1.length; i++) {
				s[i] = s1[i];
			}
			
			for(int i = 0 ; i < s2.length ; i++){
				s[s1.length+i] = s2[i];
			}
			return s;
		}
		
		static void disp2D(String[][] players){
			int i = 1;
			for (String[] player : players) {
				System.out.print("player-"+i+"--> cards are:- ");
				for (String cards : player) {
					System.out.print(cards+" ");
				}
				i++;
				System.out.println();
			}
		}
		
		public static String[] insertionSort(String[] s) {
			for (int i = 1; i < s.length; i++) {
				int j = i - 1;
				String temp = s[i];
				while (j >= 0 && temp.compareTo(s[j]) < 0) {
					s[j + 1] = s[j];
					j--;
				}
				s[++j] = temp;
			}
			return s;
		}
		
		
	public static void main(String[] args) {
		
		String[] clubes = {"C2", "C3" , "C4" , "C5" , "C6" , "C7" , "C8" , "C9" , "C10" , "CJack" , "CQueen" , "CKing" , "CAce" };
		String[] diamonds = {"D2", "D3" , "D4" , "D5" , "D6" , "D7" , "D8" , "D9" , "D10" , "DJack" , "DQueen" , "DKing" , "DAce" };
		String[] hearts = {"H2", "H3" , "H4" , "H5" , "H6" , "H7" , "H8" , "H9" , "H10" , "HJack" , "HQueen" , "HKing" , "HAce" };
		String[] spades = {"S2", "S3" , "S4" , "S5" , "S6" , "S7" , "S8" , "S9" , "S10" , "SJack" , "SQueen" , "SKing" , "SAce" };
		
		String[] cards1 = concate(clubes, diamonds);
		String[] cards2 = concate(hearts,spades);
		String[] cards = concate(cards1, cards2);
		disp(cards);
		System.out.println(cards.length);
		shuffle(cards);
		
		String[][] players = new String[4][9];
		int k = 0;
		
		ArrayList<String[]> play = new ArrayList<String[]>();
		
		for(int i = 0 ; i < players.length ; i++){
			String[] player = new String[9];
			
			for(int j = 0 ; j< players[i].length ; j++){	
				players[i][j] = cards[k];
				player[j] = cards[k];
				k++;
			}
			play.add(player);
		}
		
		disp2D(players);
		
		for(String[] player : play){
			insertionSort(player);
			disp(player);
		}
		

		
	}

}
