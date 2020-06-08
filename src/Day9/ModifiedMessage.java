package Day9;

import java.util.Scanner;

public class ModifiedMessage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = "Hello <<name>>, We have your full name as \n<<full name>> in our system. your contact number is 91-xxxxxxxxxx. Please,let us know \nin case of any clarification Thank you BridgeLabz 01/01/2016. Use Regex to replace \nname, full name, Mobile#, and Date with proper value.";
		System.out.println("Enter the name");
		s = s.replace("<<name>>", "kanth");
		s = s.replace("<<full name>>", "Lakshmikanth N");
		s = s.replaceAll("91-xxxxxxxxxx", "91-9036128355");
		s = s.replaceAll("\\d{2}/\\d{2}/\\d{4}", "17/01/1997");
		System.out.println(s);
		in.close();
	}

}
