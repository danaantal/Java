import java.util.ArrayList;

public class Graph {

	public ArrayList<Node> nodes;
	public ArrayList<Edge> edges;
	public ArrayList<ArrayList<Node>> tgPath;
	public ArrayList<ArrayList<Node>> isles;

	public Graph() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		tgPath = new ArrayList<ArrayList<Node>>();
		isles = new ArrayList<ArrayList<Node>>();
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public ArrayList<Node> getNeighbours(Node node) {// the neighbours of the
														// node
		ArrayList<Node> neighbours = new ArrayList<>();
		return neighbours;
	}

	public boolean canShare(String r, Node x, Node p, Graph G) {// p shares r
																// right to x
																// object in
																// graph G
		return true;
	}
}
