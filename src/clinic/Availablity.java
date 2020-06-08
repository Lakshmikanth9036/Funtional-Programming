package clinic;

import java.util.List;

public class Availablity {

	private int date;
	private String month;
	private String availablity;
	private List<Patient> patients;
	
	public Availablity(int date, String month, String availablity) {
		super();
		this.date = date;
		this.month = month;
		this.availablity = availablity;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAvailablity() {
		return availablity;
	}

	public void setAvailablity(String availablity) {
		this.availablity = availablity;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Availablity [date=" + date + ", month=" + month + ", availablity=" + availablity + ", patients="
				+ patients + "]";
	}

}
