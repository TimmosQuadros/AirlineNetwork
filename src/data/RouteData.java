package data;

public class RouteData {
	
	private String airlineCode;
	private String sourceCode;
	private String destinationCode;
	private Float distance;
	private Float time;
	public RouteData(String airlineCode, String sourceCode, String destinationCode, Float distance, Float time) {
		super();
		this.airlineCode = airlineCode;
		this.sourceCode = sourceCode;
		this.destinationCode = destinationCode;
		this.distance = distance;
		this.time = time;
	}
	public String getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public String getDestinationCode() {
		return destinationCode;
	}
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}
	public Float getDistance() {
		return distance;
	}
	public void setDistance(Float distance) {
		this.distance = distance;
	}
	public Float getTime() {
		return time;
	}
	public void setTime(Float time) {
		this.time = time;
	}
	
	

}
