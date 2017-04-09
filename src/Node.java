import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
	
	private List<Edge> edges;

	private boolean isVisited;
	private Float cost; //The cost to get to this vertex/node from the origin or start vertex/node used only for Dijkstra's algorithm
	private Node path; //Path to origin vertex/node default equals null
	
	//for Prim's MST alghoritm
	private Node parrent;
	
	//Data
	private String airlineCode;
	private String name;
	private String city;
	private String country;
	private Float latitude;
	private Float longitude;
	
	

	public Node(Float cost) {
		super();
		this.cost = cost;
	}

	public Node(String airlineCode) {
		super();
		this.edges = new ArrayList<>();
		this.airlineCode = airlineCode;
		this.isVisited = false;
		this.cost = 99999999f;
	}

	public Node(String airlineCode, String name, String city, String country, Float latitude, Float longitude) {
		super();
		this.airlineCode = airlineCode;
		this.name = name;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}





	public boolean addEdge(Node destination,Float weight){
		return edges.add(new Edge(this, destination, weight));
	}
	
	public boolean removeEdge(Node origin, Node destination){
		int i = 0;
		for (Edge edge : edges) {
			if(edge.getOrigin().equals(origin) && edge.getDestination().equals(destination)){
				return edges.remove(i) != null;
			}
			i++;
		}
		return false;
	}

	@Override
	public int compareTo(Node node) {
		if(this.getCost()<node.getCost()){
			return -1;
		}else if(this.getCost()>node.getCost()){
			return 1;
		}else{
			return 0;
		}
		//return this.cost.compareTo(node.getCost());
	}

	public List<Edge> getEdges() {
		return edges;
	}



	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}



	public String getAirlineCode() {
		return airlineCode;
	}



	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}



	public boolean isVisited() {
		return isVisited;
	}



	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}



	public Float getCost() {
		return cost;
	}



	public void setCost(Float cost) {
		this.cost = cost;
	}



	public Node getPath() {
		return path;
	}



	public void setPath(Node path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Node getParrent() {
		return parrent;
	}

	public void setParrent(Node parrent) {
		this.parrent = parrent;
	}
	
	
	
	
	
	
	
}
