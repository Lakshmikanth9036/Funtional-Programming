package Day9;

import java.util.Scanner;

public class MacDonald {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = "Old MacDonald had a farm,\nE-I-E-I-O.\nAnd on his farm he had some %ANIMAL%,\nE-I-E-I-O.\nWith a %SOUND%, %SOUND% here,\nAnd a %SOUND%, %SOUND% there,\nHere a %SOUND%, there a %SOUND%,\nEverywhere a %SOUND%, %SOUND%,";
		System.out.println("Enter the Animal name");
		String animal = in.next();
		in.nextLine();
		System.out.println("Enter the Animals sound");
		String sound = in.nextLine();
		String replaceStr = str.replace("%ANIMAL%", animal);
		replaceStr = replaceStr.replace("%SOUND%", sound);
		System.out.println(replaceStr);
		in.close();
	}

}
