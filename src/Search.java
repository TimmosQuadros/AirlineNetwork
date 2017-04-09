import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Search {

	Stack<Node> stack = new Stack<Node>();
	ListQueue<Node> queue = new ListQueue<>();

	ConcurrentHashMap<String, Node> nodes;

	public Search(AirlineGraph graph) {
		nodes = graph.getVertices();
	}

	public ArrayList<Node> bfs(Node start) {
		ArrayList<Node> output = new ArrayList<>();
		Node pointer = start;
		pointer.setVisited(true);
		output.add(pointer);
		while(queue.size()>0||pointer.equals(start)){
			for (Edge edge : pointer.getEdges()) {
				if(!edge.getDestination().isVisited()){
					Node next = edge.getDestination();
					queue.enqueue(next);
					next.setVisited(true);
					output.add(next);
				}
			}
			pointer = queue.dequeue();
		}
		return output;
	}

	public ArrayList<Node> dfs(Node start) {
		ArrayList<Node> output = new ArrayList<>();
		stack.push(start); //add to stack
		output.add(start); //add to output
		start.setVisited(true); //mark as visited
		Node next;
		while(!stack.isEmpty()){
			next = stack.peek();
			List<Edge> edges = next.getEdges();
			if(!edges.isEmpty()){
				Iterator<Edge> airportCodes = edges.iterator();	
				while(airportCodes.hasNext()){
					Node nextEdgeDest = airportCodes.next().getDestination();
					if(!nextEdgeDest.isVisited()){ //if not visited
						stack.push(nextEdgeDest);
						output.add(nextEdgeDest);
						nextEdgeDest.setVisited(true);
						break;
					}else if(nextEdgeDest.isVisited()&&!airportCodes.hasNext()){ //if nextEdge is visited and no more edges 
						stack.pop();
					}
				}
			}else{
				stack.pop();
			}
		}
		return output;
	}

	public List<Edge> getMinSpanTree(List<Node> vertices){ //Prims alghorihtm
		NodeHeap queue = new NodeHeap(vertices.size());
		List<Edge> result = new ArrayList<>(); //A = Ø
		Node vertice = vertices.get(0);
		vertice.setCost(0f); //KEY[r]=0
		queue.enqueue(vertice);
		for (Node node : vertices) {
			node.setCost(99999999f); //KEY[V] = infinity
			node.setParrent(null); //PARENT[V] = null
			queue.enqueue(node);
		}

		while(!queue.isEmpty()){ //Q!=Ø
			Node u = queue.dequeue(); //u=min(Q) by KEY value, Q=Q-u
			if(u.getParrent()!=null){ //if PARENT(u)!=null:
				result.add(new Edge(u, u.getParrent(), u.getParrent().getCost()));
			}
			for (Edge edge : u.getEdges()) { //Note that if there are parallel edges it wont work
				Node v = edge.getDestination();
				if(edge.getWeight()<v.getCost()){
					v.setParrent(u);
					v.setCost(edge.getWeight());
					if(edge.getWeight()<queue.getRoot().getCost()){
						queue.swapRoot();
					}else if(edge.getWeight()<queue.getSeccondVertice().getCost()){
						queue.swapSeccond();
					}
				}
			}
		}
		return result;
	}

	public List<Edge> mergeSort(List<Edge> list){

		if(list.size()<=1){
			return list;
		}

		List<Edge> left = new ArrayList<>();
		List<Edge> right = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if(i<(list.size())/2){
				left.add(list.get(i));
			}else{
				right.add(list.get(i));
			}
		}
		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left,right);
	}

	private ArrayList<Edge> merge(List<Edge> left,List<Edge> right){
		ArrayList<Edge> res = new ArrayList<>();
		while(!(left.isEmpty() && right.isEmpty())){
			if(!left.isEmpty() && !right.isEmpty()){
				if(left.get(0).compareTo(right.get(0))<0){
					res.add(left.get(0));
					left.remove(0);
				}else if(!right.isEmpty()){
					res.add(right.get(0));
					right.remove(0);
				}	
			}else if(left.isEmpty() && !right.isEmpty()){
				res.add(right.get(0));
				right.remove(0);
			}else if(right.isEmpty() && !left.isEmpty()){
				res.add(left.get(0));
				left.remove(0);
			}
		}
		return res;
	}



}
