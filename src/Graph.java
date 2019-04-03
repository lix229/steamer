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
		adj[e.from].add(e);
		adj[e.to].add(e);
	}
}
