package AddressBook;

import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		AddressBookService addressLibrery = new AddressBookServiceProvider();

		String ans = "";

		do {
			System.out.println("1. Add a person details in perticular address book\n"
					+ "2. Edit a person details in perticular address book\n"
					+ "3. Delete  person details in perticular address book\n" + "4. Print address books Entries\n"
					+ "5. Print the Entries sorted by Last Name\n" + "6. Print the Entries sorted by ZipCode\n"
					+ "7. Create new address book\n" + "8. Save address book\n" + "9. Quit");
			System.out.println();
			System.out.println("Enter your choice: ");
			int choice = in.nextInt();
			System.out.println();

			switch (choice) {
			case 1:
				addressLibrery.addPerson();
				break;

			case 2:
				addressLibrery.editPersonDetails();
				break;

			case 3:
				addressLibrery.deletePerson();
				break;

			case 4:
				addressLibrery.printEntries();
				break;

			case 5:
				addressLibrery.sortEntriesByName();
				break;

			case 6:
				addressLibrery.sortEntriesByZip();
				break;

			case 7:
				addressLibrery.createNewAddressBook();
				break;

			case 8:
				addressLibrery.saveAddressBook();
				break;

			case 9:
				System.out.println("Do you commit the changes that you have made in the address book");
				System.out.println("If yes perss y/y");
				ans = in.next();
				if (ans.equalsIgnoreCase("y"))
					addressLibrery.saveAddressBook();
				break;
				//default
			}

			System.out.println("Do you want to stay in libray if yes press y/Y");
			ans = in.next();
		} while (ans.equalsIgnoreCase("y"));

	}
}
