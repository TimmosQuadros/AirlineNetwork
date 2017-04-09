
public class Edge {
	
	private Node origin;
	private Node destination;
	private Float weight;
	
	//Data
	private String airlineCode;
	private Float distance;
	private Float time;
	
	public Edge(Node origin, Node destination, Float weight) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
	}
	
	public Edge(Node origin, Node destination, Float weight, String airlineCode, Float distance, Float time) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
		this.airlineCode = airlineCode;
		this.distance = distance;
		this.time = time;
	}



	public Node getOrigin() {
		return origin;
	}
	public void setOrigin(Node origin) {
		this.origin = origin;
	}
	public Node getDestination() {
		return destination;
	}
	public void setDestination(Node destination) {
		this.destination = destination;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
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

	public int compareTo(Edge edge) {
		if(this.weight>edge.weight){
			return 1;
		}else if(this.weight<edge.weight){
			return -1;
		}else{
			return 0;	
		}
	}
	
	

}
