
public class Node {
	public String name;//node name
	public String type;//subject or object

	public Node(String n, String t) {
		this.name = n;
		this.type = t;
	}
	@Override
	public String toString(){
		return name+"("+type+")";
	}
}
