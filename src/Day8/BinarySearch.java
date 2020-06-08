package Day8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BinarySearch {
	public static String[] split(){
		BufferedReader reader = null;
		String[] words = null;
		try{
			reader = new BufferedReader(new FileReader("F:\\file.txt"));
			String line = null;
			while((line = reader.readLine()) != null){
				words = line.split(",");
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(reader != null){
				try{
					reader.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return words;
	}
	
	public static int binarySearch(String[] s, String ele, int l, int h){
		int mid = (l+h)/2;
		if(l>h)
			return -1;
		if(s[mid].equals(ele))
			return mid;
		if(s[mid].compareTo(ele)<0)
			l = mid+1;
		if(s[mid].compareTo(ele)>0)
			h = mid-1;
		return binarySearch(s, ele, l, h);
		
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(split()));
		System.out.println(split().length);
		String[] s = split();
		int i = binarySearch(s, "ice", 0, s.length-1);
		System.out.println(i);
//		System.out.println(s[i]);
	}


	
}
