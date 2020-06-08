package clinic;

public class Patient {
	
	private int id;
	private String name;
	private long mobile;
	private int age;
	
	public Patient(int id, String name, long mobile, int age) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", mobile=" + mobile + ", age=" + age + "]";
	}
	
}
