import java.util.ArrayList;

public class Graph {
	private int V;
	private ArrayList<Edge>[] adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.adj = (ArrayList<Edge>[]) new ArrayList[V];
		for (int i=0; i<V; ++i) {
			this.adj[i] = new ArrayList<Edge>();
		}
	}
	
	public int V() {
		return this.V;
	}
	
	public ArrayList<Edge> getAdjList(int i) {
		return this.adj[i];
	}
	
	//undirected graph
	public void addEdge(Edge e) {
		validateVertex(e.getFrom());
        validateVertex(e.getTo());
		adj[e.getFrom()].add(e);
		adj[e.getTo()].add(e);
	}
	
	private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
