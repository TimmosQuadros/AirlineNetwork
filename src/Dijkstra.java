import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import data.AirportData;
import data.RouteData;

public class Dijkstra {

	public static void main(String[] args) {
		AirlineGraph ag = new AirlineGraph();

		FileHandler fh = new FileHandler();

		List<AirportData> airports = fh.loadAirportsFromFile("C:/temp/airports.txt");
		List<RouteData> routes = fh.loadRoutesFromFile("C:/temp/routes.txt");

		for (AirportData airportData : airports) {
			Node n = new Node(airportData.getAirlineCode());
			ag.addVertex(n);
		}

		ConcurrentHashMap<String, Node> nodes = ag.getVertices();

		for (RouteData routeData : routes) {
			//Fast fix not pretty :-|
			Node n = nodes.get(routeData.getSourceCode());
			n.addEdge(nodes.get(routeData.getDestinationCode()), routeData.getDistance()); //Extremely readable :-)
			List<Edge> edges = n.getEdges();
			edges.get(edges.size()-1).setAirlineCode(routeData.getAirlineCode());
		}

//		Dijkstra dj =new Dijkstra();
		
		//List<String>shortestPath = dj.findShortestPath(nodes.get("KZN"), nodes.get("MSQ"));
		
//		for (String airlineCode : shortestPath) {
//			System.out.println(airlineCode);
//		}
		
		Search s = new Search(ag);
		//ArrayList<Node> dfsOutput = s.dfs(nodes.get("KZN"));
		
		//ArrayList<Node> bfsOutput = s.bfs(nodes.get("KZN"));
//		for (Node node : dfsOutput) {
//			System.out.println(node.getAirlineCode());
//		}
//		System.out.println(dfsOutput.size());
		
		
		List<Edge> allEdges = new ArrayList<>();
		List<Edge> allEdgesWithDuplicates = new ArrayList<>();
		//First sort the edges in the tree
		Iterator<Node> iterator = nodes.values().iterator();
		List<Node> vertices = new ArrayList<>();
		while(iterator.hasNext()){
			vertices.add(iterator.next());
		}
		
		for (Node node : vertices) {
			for (Edge edge : node.getEdges()) {
				allEdgesWithDuplicates.add(edge);
			}
			
		}
		
		allEdgesWithDuplicates=s.mergeSort(allEdgesWithDuplicates);
		
		Edge tmp = null;
		for (int i = 0; i < allEdgesWithDuplicates.size(); i++) {
			Edge edge = allEdgesWithDuplicates.get(i);
			if(tmp!=null&&!edge.getDestination().getAirlineCode().equalsIgnoreCase(tmp.getDestination().getAirlineCode())){
				allEdges.add(edge);
				System.out.println(edge.getOrigin().getAirlineCode()+"-"+edge.getDestination().getAirlineCode()+" "+edge.getWeight()+" "+edge.getAirlineCode());
			}else if(tmp==null){
				allEdges.add(edge);
				System.out.println(edge.getOrigin().getAirlineCode()+"-"+edge.getDestination().getAirlineCode()+" "+edge.getWeight()+" "+edge.getAirlineCode());
			}
			tmp = allEdgesWithDuplicates.get(i);
		}
		
		
		
//		for (RouteData routeData : routes) {
//			if(routeData.getSourceCode().equalsIgnoreCase("KZN")){
//				System.out.println(routeData.getSourceCode()+"-"+routeData.getDestinationCode());
//			}
//		}
	}

	public List<String> findShortestPath(Node orig,Node dest){
		Node origin = orig;
		orig.setCost(0f);
		List<Edge> edges;
		NodeHeap nh = new NodeHeap(1000000);
		while(nh.size()>0||!origin.isVisited()){
			origin.setVisited(true);
			edges = orig.getEdges();
			for (Edge edge : edges) {
				Node neighbor = edge.getDestination();
				Float weight = edge.getWeight();
				Float cost_orig = orig.getCost();
				Float cost_dest = neighbor.getCost();
				Float new_cost=cost_orig+weight;
				if(new_cost<cost_dest){
					neighbor.setCost(new_cost);
					neighbor.setPath(orig);
					nh.enqueue(neighbor); //I'm using a min-heap to find the next node to visit
				}
			}
			orig = nh.dequeue();
			orig.setVisited(true);
		}

		List<String> shortestPath = new ArrayList<>();
		Node next = dest.getPath();
		if(next.equals(origin)){
			shortestPath.add(dest.getAirlineCode());
			shortestPath.add(origin.getAirlineCode());
		}else{
			shortestPath.add(dest.getAirlineCode());
			while(!next.equals(origin)){
				shortestPath.add(next.getAirlineCode());
				next = next.getPath();
			}
			shortestPath.add(next.getAirlineCode());
		}
		Collections.reverse(shortestPath.subList(0, shortestPath.size()));
		return shortestPath;
		
		//Test From KZN to MSQ
	}

}
