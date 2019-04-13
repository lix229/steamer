
public class Edge {
	private final int from;
	private final int to;
	private final double relativePlay;
	
	public Edge(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.relativePlay = weight;
	}
	
	public int getFrom() {
		return this.from;
	}
	
	public int getTo() {
		return this.to;
	}
	
	public double getRelative() {
		return this.relativePlay;
	}
}