package clinic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class Runner {

	static JSONObject obj;
	
	public static JSONObject getJSONObject(){
		try {
			obj = (JSONObject) new JSONParser().parse(new FileReader("src/com/json/files/clinic.json"));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void writeToJSONObject(JSONObject obj){
		try(PrintWriter writer = new PrintWriter("src/com/json/files/clinic.json")){
			writer.write(obj.toJSONString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		JSONObject clnc = getJSONObject();
		JSONArray docs = (JSONArray) clnc.get("Clinic");
		Gson gson = new Gson();
		String ans;
		
		do{

			System.out.println("1. Add Doctors\n"
					+ "2. Tack appointments \n"
					+ "3. dispaly doctor status");
			System.out.println("Enter your choice ");
			int choice = in.nextInt();

			switch(choice){
			case 1:
				System.out.println("Enter your id ");
				int id = in.nextInt();
				System.out.println("Enter your name");
				String name = in.next();
				System.out.println("Enter the date");
				int date = in.nextInt();
				System.out.println("Enter the month");
				String month = in.next();
				System.out.println("Enter the availablity");
				String availablity = in.next();
				Availablity ab = new Availablity(date, month, availablity);
				List<Availablity> aval = new ArrayList<Availablity>();
				aval.add(ab);
				Doctor doc = new Doctor(id, name, aval);
				String ref = gson.toJson(doc);
				docs.add(ref);
				writeToJSONObject(clnc);
				break;
			
			case 2:
				for( int i = 0 ;  i < docs.size() ; i++){
					Doctor doct = gson.fromJson((String)docs.get(i), Doctor.class); 
					List<Availablity> avail = (List<Availablity>) doct.getAvailable();
					avail.forEach(System.out::println);
				}
			
			}
			System.out.println("Do you want to continue");
			ans = in.next();
		}while(ans.equalsIgnoreCase("y"));

	}

}
