
public class Edge {
	public Node initial;//the edge goes from here
	public Node finall;//the edge arrives here
	public String right;//the right shared by the two nodes

	public Edge(Node i, Node f, String r){
		this.initial  = i;
		this.finall = f;
		this.right = r;
	}

	public String getRight(){
		return right;
	}
	@Override
	public String toString() {
		return initial + " ==> " + finall;
	}
}
