package Day9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;


public class Test {

	
	 ArrayList list = data();
	 
	ArrayList data(){
		 return new ArrayList(){{
			 add("1");
			 add("1");
			 add("1");
			 add("1");
		 }};
	 }
	
	 void foreach(Consumer<? super Collection> data){

		data.accept(this.list);
		
	}
	
	 
	 public static void main(String[] args) {
		
		 
		 new Test().foreach(list -> System.out.print(list));
		 
		 
		 
	}
	
	
	
	
	
}
