import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface Graph<D,W> {
  void addVertex(D data);
  void addEdge(W weight, Vertex<D,W> tail, Vertex<D,W> head, boolean undirected);
  
  default void addEdge(W weight, D tailData, D headData, boolean undirected) {
    addEdge(weight, vertexOf(tailData), vertexOf(headData), undirected);
    }
  
  Vertex<D, W> vertexOf(D data);
  
  ConcurrentHashMap<String, Node> getVertices();
  Collection<Edge<D,W>> getEdges();
  
  default void print(PrintStream out) {
    out.println(toString());
    }
  
  interface Vertex<D,W> {
    D getData();
    Collection<Edge<D,W>> getAdjacentEdges();
    }
  
  interface Edge<D,W> {
    W getWeight();
    Vertex<D,W> getHeadVertex();
    }
  
  }
