package AddressBook;

public class Person {

	private String fname;
	private String lname;
	private String city;
	private Integer zipcode;
	private Long mobileNo;

	public Person(String fname, String lname, String city, Integer zipcode, Long mobileNo) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.zipcode = zipcode;
		this.mobileNo = mobileNo;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "{ fname : " + fname + "\nlname : " + lname + "\ncity : " + city + "\nzipcode : " + zipcode
				+ "\nmobileNo : " + mobileNo + " }";
	}

}
