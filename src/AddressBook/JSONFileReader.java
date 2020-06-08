package AddressBook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFileReader {
	private static final String PATH = "src/com/json/files/AddressBook.json";

	public static JSONObject getJSONObject() {
		JSONObject obj = null;
		try {
			obj = (JSONObject) new JSONParser().parse(new FileReader(PATH));
		} catch (Exception e) {
			
		}
		return obj;
	}

	public static void write(JSONObject obj) {
		try (PrintWriter writer = new PrintWriter(PATH);) {
			writer.write(obj.toJSONString());
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
