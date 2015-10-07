package utn.frd.bean;

public class Person {

	private int id;
	private String name;
	private String address;
	
	public Person(){}
	
	public Person(int id, String name, String address){
		this.id = id;
		this.name = name;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getLastName() {
		return name.split(" ")[1];
	}	
	public String getFirstName() {
		return name.split(" ")[0];
	}	
	public String getStreet() {
		return address.split(", ")[0];
	}	
	public String getCity() {
		return address.split(", ")[1];
	}	
}