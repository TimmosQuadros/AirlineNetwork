package data;

public class AirlineData {
	
	private String airlineCode;
	private String name;
	private String country;
	public AirlineData(String airlineCode, String name, String country) {
		super();
		this.airlineCode = airlineCode;
		this.name = name;
		this.country = country;
	}
	public String getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
