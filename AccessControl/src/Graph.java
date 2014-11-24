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

	public void tgPaths(Node end, ArrayList<Node> visited) {// DFS x2
		ArrayList<Node> nods_neighbor = this.getNeighbors(visited.get(visited
				.size() - 1));

		for (Node node : nods_neighbor) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.equals(end)) {
				visited.add(node);
				printPath(new ArrayList<Node>(visited));
				visited.remove(visited.size() - 1);
				break;
			}
		}

		for (Node node : nods_neighbor) {
			if (visited.contains(node) || node.equals(end)) {
				continue;
			}
			visited.add(node);
			tgPaths(end, visited);
			visited.remove(visited.size() - 1);
		}
	}

	public void printPath(ArrayList<Node> path) {
		System.out.print("Tg Path: ");
		this.tgPath.add(path);
		for (Node n : path) {
			System.out.print(n);
		}
		System.out.println("");
	}

	public ArrayList<Node> getNeighbors(Node i) {// the neighbors of the
													// node
		ArrayList<Node> neighbor = new ArrayList<Node>();
		ArrayList<Node> visited = new ArrayList<Node>();
		for (Edge edge : edges) {
			if (edge.initial == i // if initial node && final node of the edge
									// was not visited && the right is "take" or
									// "grant"
					&& (!visited.contains(edge.finall))
					&& (edge.right.equals("grant") || edge.right.equals("take"))) {
				neighbor.add(edge.finall);// the final node of the edge is a
											// neighbor
			} else if (edge.finall == i // if final node && initial node of the
										// edge was not visited && the labeled
										// right is "take" or "grant"
					&& (!visited.contains(edge.initial))
					&& (edge.right.equals("grant") || edge.right.equals("take"))) {
				neighbor.add(edge.initial);// the initial node of the edge is a
											// neighbor
			}
		}
		return neighbor;
	}

	public void getIsle() {// get isle
		ArrayList<Node> isle = new ArrayList<Node>();// array of nodes

		for (ArrayList<Node> tgpath : tgPath) {// foreach tgpath from the array
												// of tgpaths
			for (Node nod : tgpath) {// foreach node of tgpath
				if (nod.type.equals("sub")) {// if subject
					isle.add(nod);// add the node to the current isle
				} else {// else create a new isle after adding the previously
						// created to the array
					this.isles.add(isle);

					for (int i = 0; i < isle.size(); i++) {
						System.out.println("Isle: " + isle.get(i).toString());						
					}
					isle = new ArrayList<Node>();
				}
			}
		}
	}

	public boolean getBrigde() {
		ArrayList<Node> bridge = new ArrayList<Node>();
		boolean flag = false;
		int countMax = this.isles.size() - 1;
		int count = 0;

		for (count = 0; count < countMax; count++) {
			if(count == countMax - 1)
				{
				break;
				}
			Node from = this.isles.get(count).get(isles.get(count).size() - 1);
			Node to = this.isles.get(count + 1).get(0);
			flag = false;
			for (Node nod : this.tgPath.get(0)) {
				if (nod == from) {
					flag = true;
				}
				if (flag == true) {
					bridge.add(nod);
				}
				if (nod == to) {
					flag = false;
					break;
				}
			}

			if (isBridge(bridge) == false) {
				return false;
			}
			bridge = new ArrayList<Node>();
			for(int i=0;i<bridge.size();i++){
				System.out.println("Bridge: " + bridge.get(i));
			}
			System.out.println("count: " + count);
		}
		return true;
	}

	public boolean isBridge(ArrayList<Node> nodes) {// t*<- OR t*-> OR t*->g->t*<- OR t*->g<-t*<-
		for (int i = 0; i < edges.size(); i++) {
			Edge edge;
			edge = edges.get(i);
			if (terminalSpan(edge.initial) == true
					|| terminalSpan(edge.finall) == true
					|| (initialSpan(edge.initial) == true && terminalSpan(edge.finall) == true)
					|| (initialSpan(edge.finall) == true && terminalSpan(edge.initial) == true)) {

				return true;
			}
		}
		return false;
	}
	//SECOND CONDITION from Theorem 5
	public boolean initialSpan(Node node) {// p extends to p' -> "take" and
											// "grant"
											// rights
		ArrayList<Node> inSpan = new ArrayList<Node>();
		inSpan.add(node);
		boolean flag = false;
		Edge edge;

		for (int i = 0; i < edges.size(); i++) {
			edge = edges.get(i);
			if (edge.initial == node && edge.right.equals("take")) {// verify
																	// all the
																	// "take"
																	// labeled
																	// edges
																	// from the
																	// BEGINING
				inSpan.add(edge.finall);// add the final node to the array
				node = edge.finall;// the current node is the final node of the
									// checked edge
				i++;
				flag = true;
			} else if (edge.initial == node && edge.right.equals("grant")) {// verify
																			// all
																			// the
																			// "grant"
																			// labeled
																			// edges
																			// from
																			// the
																			// BEGINING
				inSpan.add(edge.finall);
				flag = true;
				break;
			}
		}
		System.out.println("InitialSpan: " + inSpan);
		return flag;
	}
	//THIRD CONDITION from Theorem 5
	public boolean terminalSpan(Node node) {// s extends to s' -> only "take"
											// rights
		ArrayList<Node> termSpan = new ArrayList<Node>();
		termSpan.add(node);
		boolean flag = false;
		int j;
		Edge edge;

		for (int i = 0; i < edges.size(); i++) {
			edge = edges.get(i);
			if (edge.finall == node && edge.right.equals("take")) {// verify all the"take" labeled edges from the END
				termSpan.add(edge.initial);
				node = edge.initial;
				i--;
				flag = true;
			}
		}
		j = termSpan.size() - 1;
		for (; j > 0; j--) {
			if (termSpan.get(j).type.equals("ob")) {// if the terminal span contains objects we remove them because 
													//we want to know the "take" path through subjects
				termSpan.remove(termSpan.get(j));
			} else {
				break;
			}
		}
		System.out.println("TerminalSpan" + termSpan);
		return flag;
	}

	public boolean canShare(String r, Node x, Node p, Graph G) {// p shares r right with x object in graph G
		Node node = null;
		boolean flag = false;
		for (Edge edge : edges) {
			if (edge.finall == x && edge.right.equals("r/w")) {// if x final node and the edge is labeled with "r/w" right
				flag = true;
				node = edge.initial;
			}
		}
		if (flag == true) {
			if (this.initialSpan(p) == true) {
				if (this.terminalSpan(node) == true) {
					ArrayList<Node> visited = new ArrayList<Node>();
					visited.add(p);
					tgPaths(node, visited);
					this.getIsle();
					if (this.getBrigde() == false) {
						return false;
					}
				} else {
					return false;
				}
			}// endif terminalSpan
		}// endif initialSpan

		return flag;
	}// endif flag

}
