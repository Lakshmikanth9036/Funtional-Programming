package clinic;

import java.util.List;

public class Doctor {

	private int id;
	private String name;
	private List<Availablity> available;
	
	public Doctor(int id, String name, List<Availablity> available) {
		super();
		this.id = id;
		this.name = name;
		this.available = available;
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
	
	public List<Availablity> getAvailable() {
		return available;
	}
	
	public void setAvailable(List<Availablity> available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", available=" + available + "]";
	}

	
}
