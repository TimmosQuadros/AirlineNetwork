import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class AirlineGraph implements Graph<Node, Weight>{

	ConcurrentHashMap<String, Node> nodes = new ConcurrentHashMap<>();

	@Override
	public void addVertex(Node data) {
		Node n = new Node(data.getAirlineCode());
		nodes.put(data.getAirlineCode(), n);
	}

	@Override
	public void addEdge(Weight weight, Graph.Vertex<Node, Weight> tail, Graph.Vertex<Node, Weight> head,
			boolean undirected) {

		Node node = nodes.get(head.getData().getAirlineCode());
		if(node==null){
			throw new NoSuchElementException();	
		}
		node.addEdge(tail.getData(), weight.getDistance().floatValue());
	}

	@Override
	public Graph.Vertex<Node, Weight> vertexOf(Node data) {

		return null;
	}

	@Override
	public ConcurrentHashMap<String, Node> getVertices() {

		return this.nodes;
	}

	@Override
	public Collection<Graph.Edge<Node, Weight>> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}







}
