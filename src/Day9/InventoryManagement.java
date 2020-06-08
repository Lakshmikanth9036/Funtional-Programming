package Day9;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class InventoryManagement {


	public static void main(String[] args) {
		try {
			Object obj = new JSONParser().parse(new FileReader("src/com/json/files/InventoryDetails.json")) ;
			JSONObject jobj = (JSONObject) obj;
			long value = 0;
			
			for(Object val: jobj.values()){
				Map m= (Map) val;
				m.forEach((k,v) -> {System.out.println(k+" "+v);});
				long v = (long) m.get("price")*(long) m.get("weigth");
				System.out.println("Total value of this inventory: "+v );
				value = value+v;
				System.out.println();
			}
			
			System.out.println("Total value of the inventory: "+value);


		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
