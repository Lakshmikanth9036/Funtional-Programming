package AddressBook;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

public class AddressBookServiceProvider implements AddressBookService {

	static Scanner in = new Scanner(System.in);

	static JSONObject addressLibrary = JSONFileReader.getJSONObject();
	static Gson gson = new Gson();

	public static String[] choices(JSONObject addressLibrary) {
		String[] addrName = new String[addressLibrary.size()];
		int i = 0;
		System.out.println("Existing Address books in library are:");

		for (Object addressBookName : addressLibrary.keySet()) {
			String name = addressBookName.toString();
			addrName[i++] = name;
			System.out.println(i + ". " + name);
		}
		return addrName;
	}

	public void addPerson() {

		String[] addrName = choices(addressLibrary);

		String ans = "";

		System.out.println("Choose the address book where you want like to store your details");
		System.out.println("Pick your choice");
		int choice = in.nextInt();
		JSONArray addressBook = (JSONArray) addressLibrary.get(addrName[choice - 1]);
		System.out.println("Enter first name");
		String fname = in.next();
		System.out.println("Enter last name");
		String lname = in.next();
		System.out.println("Enter city");
		String city = in.next();
		System.out.println("Enter zipcode");
		int zip = in.nextInt();
		System.out.println("Enter mobile number");
		long mobile = in.nextLong();

		Person person = new Person(fname, lname, city, zip, mobile);

		String prsn = gson.toJson(person);
		addressBook.add(prsn);
		System.out.println("Successfully added person details.....");
		System.out.println("Do you commit the changes that you have made in the address book");
		System.out.println("If yes perss y/y");
		ans = in.next();
		if (ans.equalsIgnoreCase("y"))
			saveAddressBook();
	}

	public void editPersonDetails() {

		String[] addrName = choices(addressLibrary);

		String ans = "";

		System.out.println("Choose the address book where you want like to store your details");
		System.out.println("Pick your choice");
		int choice = in.nextInt();
		JSONArray addressBook = (JSONArray) addressLibrary.get(addrName[choice - 1]);

		System.out.println("Enter the last name");
		String lastName = in.next();

		for (int i = 0; i < addressBook.size(); i++) {
			String prsn = (String) addressBook.get(i);
			Person person = gson.fromJson(prsn, Person.class);

			if (person.getLname().equals(lastName)) {
				System.out.println("Existing details are:-");
				System.out.println(person);
				System.out.println("Edit");
				System.out.println("Enter your First Name");
				String fname = in.next();
				person.setFname(fname);
				System.out.println("Enter city");
				String city = in.next();
				person.setCity(city);
				System.out.println("Enter zipcode");
				Integer zip = in.nextInt();
				person.setZipcode(zip);
				System.out.println("Enter mobile number");
				Long mobile = in.nextLong();
				person.setMobileNo(mobile);
				System.out.println("Successfully update.......");

				String jprsn = gson.toJson(person);
				addressBook.set(i, jprsn);

				break;
			} else {
				System.out.println("Plz enter the value name");
			}
		}
		System.out.println("Do you commit the changes that you have made in the address book");
		System.out.println("If yes perss y/y");
		ans = in.next();
		if (ans.equalsIgnoreCase("y"))
			saveAddressBook();
	}

	public void deletePerson() {

		String[] addrName = choices(addressLibrary);

		System.out.println("Choose the address book where you want like to store your details");
		System.out.println("Pick your choice");
		int choice = in.nextInt();
		JSONArray addressBook = (JSONArray) addressLibrary.get(addrName[choice - 1]);

		System.out.println("Enter the last name");
		String lastName = in.next();

		int k = 0;
		for (int i = 0; i < addressBook.size(); i++) {
			String prsn = (String) addressBook.get(i);
			Person person = gson.fromJson(prsn, Person.class);
			if (person.getLname().equals(lastName)) {
				System.out.println("Details");
				System.out.println(person);
				break;
			}
			k++;
		}
		System.out.println("Warning: are you sure you want to delete the above details");
		System.out.println("If yes press y/Y");
		String ans = in.next();
		if (ans.equalsIgnoreCase("y")) {
			addressBook.remove(k);
			System.out.println("Successfull removed a details.......");
		}
		System.out.println("Do you commit the changes that you have made in the address book");
		System.out.println("If yes perss y/y");
		ans = in.next();
		if (ans.equalsIgnoreCase("y"))
			saveAddressBook();
	}

	public void createNewAddressBook() {
		System.out.println("Enter the new address book name");
		String newAddressBookName = in.nextLine();
		JSONArray newAddressBook = new JSONArray();
		addressLibrary.put(newAddressBookName, newAddressBook);
		JSONFileReader.write(addressLibrary);
		saveAddressBook();
		System.out.println("Successfully created a new Address book.......");
	}

	public void printEntries() {

		for (Object addressBook : addressLibrary.values()) {
			JSONArray ad = (JSONArray) addressBook;
			for (int i = 0; i < ad.size(); i++) {
				String prsn = (String) ad.get(i);
				Person person = gson.fromJson(prsn, Person.class);
				System.out.println(person);
				System.out.println();
			}

		}
	}

	public void sortEntriesByName() {
		for (Object addressBook : addressLibrary.values()) {
			JSONArray ad = (JSONArray) addressBook;

			Comparator<String> comp = new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					Person p1 = gson.fromJson(o1, Person.class);
					Person p2 = gson.fromJson(o2, Person.class);
					return p1.getLname().compareTo(p2.getLname());
				}
			};

			Collections.sort(ad, comp);

			for (int i = 0; i < ad.size(); i++) {
				String prsn = (String) ad.get(i);
				Person person = gson.fromJson(prsn, Person.class);
				System.out.println(person);
				System.out.println();
			}
		}
	}

	public void sortEntriesByZip() {
		for (Object addressBook : addressLibrary.values()) {
			JSONArray ad = (JSONArray) addressBook;

			Comparator<String> comp = new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					Person p1 = gson.fromJson(o1, Person.class);
					Person p2 = gson.fromJson(o2, Person.class);
					return p1.getZipcode().compareTo(p2.getZipcode());
				}
			};

			Collections.sort(ad, comp);

			for (int i = 0; i < ad.size(); i++) {
				String prsn = (String) ad.get(i);
				Person person = gson.fromJson(prsn, Person.class);
				System.out.println(person);
				System.out.println();
			}
		}
	}

	public void saveAddressBook() {
		JSONFileReader.write(addressLibrary);
		System.out.println("Successfully saved the details in the Address Library............");
	}

}
