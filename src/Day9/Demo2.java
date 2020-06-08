package Day9;

public class Demo2 {

	public static void main(String[] args) {
		
	Demo d = new Demo(true);
	System.out.println(d.isPin());
	d.setPin(!d.isPin());
	System.out.println(d.isPin());
	}
}
