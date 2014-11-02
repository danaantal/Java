public class Test {

	public static void main(String[] args) {

		Graph G = new Graph();

		Node p = new Node("p", "sub");
		Node u = new Node("u", "sub");
		Node v = new Node("v", "ob");
		Node w = new Node("w", "sub");
		Node x = new Node("x", "ob");
		Node y = new Node("y", "sub");
		Node z = new Node("z", "sub");
		Node s = new Node("s", "ob");
		Node q = new Node("q", "ob");

		G.addNode(p);
		G.addNode(u);
		G.addNode(v);
		G.addNode(w);
		G.addNode(x);
		G.addNode(y);
		G.addNode(z);
		G.addNode(s);
		G.addNode(q);

		Edge e2 = new Edge(u, p, "grant");
		Edge e3 = new Edge(u, v, "take");
		Edge e4 = new Edge(v, w, "grant");
		Edge e5 = new Edge(x, w, "grant");
		Edge e6 = new Edge(y, x, "take");
		Edge e7 = new Edge(z, y, "grant");
		Edge e8 = new Edge(z, s, "take");
		Edge e9 = new Edge(s, q, "r/w");

		G.addEdge(e2);
		G.addEdge(e3);
		G.addEdge(e4);
		G.addEdge(e5);
		G.addEdge(e6);
		G.addEdge(e7);
		G.addEdge(e8);
		G.addEdge(e9);
		/*
		 * Graph G = new Graph();
		 * 
		 * Node one = new Node("1", "sub"); Node two = new Node("2", "sub");
		 * Node three = new Node("3", "sub"); Node four = new Node("4", "ob");
		 * Node five = new Node("5", "ob"); Node six = new Node("6", "ob"); Node
		 * seven = new Node("7", "ob"); Node eight = new Node("8", "ob"); Node
		 * nine = new Node("9", "sub"); Node ten = new Node("10", "sub"); Node
		 * eleven = new Node("11", "ob"); Node twelve = new Node("12", "sub");
		 * Node thirteen = new Node("13", "sub"); Node fourteen = new Node("14",
		 * "ob"); Node fifteen = new Node("15", "sub"); Node sixteen = new
		 * Node("16", "sub"); Node seventeen = new Node("17", "sub"); Node
		 * eighteen = new Node("18", "ob"); Node nineteen = new Node("19",
		 * "ob"); Node twenty = new Node("20", "ob"); Node twentyone = new
		 * Node("21", "sub"); Node twentytwo = new Node("22", "ob"); Node
		 * twentythree = new Node("23", "sub"); Node twentyfour = new Node("24",
		 * "sub"); Node twentyfive = new Node("25", "ob"); Node twentysix = new
		 * Node("26", "ob"); Node twentyseven = new Node("27", "sub"); Node
		 * twentyeight = new Node("28", "ob"); Node twentynine = new Node("29",
		 * "ob"); Node thirty = new Node("30", "ob"); Node thirtyone = new
		 * Node("31", "sub"); Node thirtytwo = new Node("32", "ob"); Node
		 * thirtythree = new Node("33", "sub"); Node thirtyfour = new Node("34",
		 * "ob"); Node thirtyfive = new Node("35", "sub"); Node thirtysix = new
		 * Node("36", "sub"); Node thirtyseven = new Node("37", "ob"); Node
		 * thirtyeight = new Node("38", "ob"); Node thirtynine = new Node("39",
		 * "ob"); Node forty = new Node("40", "ob"); Node fortyone = new
		 * Node("41", "ob"); Node fortytwo = new Node("42", "sub"); Node
		 * fortythree = new Node("43", "sub"); Node fortyfour = new Node("44",
		 * "sub"); Node fortyfive = new Node("45", "sub"); Node fortysix = new
		 * Node("46", "sub");
		 * 
		 * G.addNode(one); G.addNode(two); G.addNode(three); G.addNode(four);
		 * G.addNode(five); G.addNode(six); G.addNode(seven); G.addNode(eight);
		 * G.addNode(nine); G.addNode(ten); G.addNode(eleven);
		 * G.addNode(twelve); G.addNode(thirteen); G.addNode(fourteen);
		 * G.addNode(fifteen); G.addNode(sixteen); G.addNode(seventeen);
		 * G.addNode(eighteen); G.addNode(nineteen); G.addNode(twenty);
		 * G.addNode(twentyone); G.addNode(twentytwo); G.addNode(twentythree);
		 * G.addNode(twentyfour); G.addNode(twentyfive); G.addNode(twentysix);
		 * G.addNode(twentyseven); G.addNode(twentyeight);
		 * G.addNode(twentynine); G.addNode(thirty); G.addNode(thirtyone);
		 * G.addNode(thirtytwo); G.addNode(thirtythree); G.addNode(thirtyfour);
		 * G.addNode(thirtyfive); G.addNode(thirtysix); G.addNode(thirtyseven);
		 * G.addNode(thirtyeight); G.addNode(thirtynine); G.addNode(forty);
		 * G.addNode(fortyone); G.addNode(fortytwo); G.addNode(fortythree);
		 * G.addNode(fortyfour); G.addNode(fortyfive); G.addNode(fortysix);
		 * 
		 * Edge e1 = new Edge(one, two, "take"); Edge e2 = new Edge(one, four,
		 * "take"); Edge e3 = new Edge(five, four, "take"); Edge e4 = new
		 * Edge(six, five, "take"); Edge e5 = new Edge(two, six, "take"); Edge
		 * e6 = new Edge(seven, six, "take"); Edge e7 = new Edge(eight, seven,
		 * "take"); Edge e8 = new Edge(three, eight, "take"); Edge e9 = new
		 * Edge(nine, eight, "take"); Edge e10 = new Edge(three, nine, "take");
		 * Edge e11 = new Edge(ten, nine, "take"); Edge e12 = new Edge(twelve,
		 * eleven, "grant"); Edge e13 = new Edge(four, thirteen, "take"); Edge
		 * e14 = new Edge(thirteen, five, "take"); Edge e15 = new Edge(five,
		 * fourteen, "take"); Edge e16 = new Edge(fourteen, thirteen, "take");
		 * Edge e17 = new Edge(six, fifteen, "take"); Edge e18 = new
		 * Edge(fifteen, sixteen, "grant"); Edge e19 = new Edge(seventeen,
		 * sixteen, "grant"); Edge e20 = new Edge(eighteen, seventeen, "take");
		 * Edge e21 = new Edge(sixteen, eight, "take"); Edge e22 = new
		 * Edge(nine, eighteen, "r/w"); Edge e23 = new Edge(eighteen, nineteen,
		 * "take"); Edge e24 = new Edge(nine, nineteen, "take"); Edge e25 = new
		 * Edge(ten, nineteen, "take"); Edge e26 = new Edge(nineteen, twelve,
		 * "take"); Edge e27 = new Edge(eleven, twenty, "take"); Edge e28 = new
		 * Edge(thirteen, twentynine, "grant"); Edge e29 = new Edge(fifteen,
		 * twentynine, "take"); Edge e30 = new Edge(thirty, twentynine, "take");
		 * Edge e31 = new Edge(fifteen, twentytwo, "take"); Edge e32 = new
		 * Edge(twentytwo, thirty, "take"); Edge e33 = new Edge(twentytwo,
		 * twentythree, "grant"); Edge e34 = new Edge(sixteen, twentythree,
		 * "grant"); Edge e35 = new Edge(twentythree, twentyfour, "r/w"); Edge
		 * e36 = new Edge(twentyfour, twentyfive, "take"); Edge e37 = new
		 * Edge(twentysix, twentyfive, "take"); Edge e38 = new Edge(twentyfive,
		 * eighteen, "take"); Edge e39 = new Edge(nineteen, twentysix, "take");
		 * Edge e40 = new Edge(twentyseven, twentysix, "take"); Edge e41 = new
		 * Edge(twentyseven, twenty, "grant"); Edge e42 = new Edge(twentyseven,
		 * twentyeight, "take"); Edge e43 = new Edge(twenty, twentyeight,
		 * "take"); Edge e44 = new Edge(thirtysix, twentyone, "grant"); Edge e45
		 * = new Edge(thirtyone, thirty, "take"); Edge e46 = new Edge(thirtyone,
		 * twentyfour, "grant"); Edge e47 = new Edge(thirtyone, thirtytwo,
		 * "take"); Edge e48 = new Edge(twentyfive, thirtyone, "grant"); Edge
		 * e49 = new Edge(twentyfive, thirtytwo, "take"); Edge e50 = new
		 * Edge(thirtytwo, thirtythree, "grant"); Edge e51 = new
		 * Edge(twentyfive, thirtythree, "take"); Edge e52 = new
		 * Edge(thirtythree, thirtyfour, "r/w"); Edge e53 = new Edge(twentysix,
		 * thirtyfour, "take"); Edge e54 = new Edge(twentyeight, thirtyfour,
		 * "r/w"); Edge e55 = new Edge(thirtyfive, twentyeight, "take"); Edge
		 * e56 = new Edge(thirtysix, thirtyfive, "grant"); Edge e57 = new
		 * Edge(thirty, fortysix, "take"); Edge e58 = new Edge(thirty,
		 * thirtyseven, "take"); Edge e59 = new Edge(thirtyseven, thirtytwo,
		 * "take"); Edge e60 = new Edge(thirtyseven, thirtyeight, "take"); Edge
		 * e61 = new Edge(thirtyeight, thirtythree, "grant"); Edge e62 = new
		 * Edge(thirtyeight, thirtyfour, "r/w"); Edge e63 = new Edge(forty,
		 * fortysix, "grant"); Edge e64 = new Edge(fortyone, fortysix, "take");
		 * Edge e65 = new Edge(fortytwo, fortyone, "grant"); Edge e66 = new
		 * Edge(thirtyseven, fortytwo, "take"); Edge e67 = new Edge(fortythree,
		 * fortytwo, "grant"); Edge e68 = new Edge(fortyfour, fortythree,
		 * "grant"); Edge e69 = new Edge(fortyfour, thirtyeight, "take"); Edge
		 * e70 = new Edge(fortyfour, fortyfive, "grant");
		 * 
		 * G.addEdge(e1); G.addEdge(e2); G.addEdge(e3); G.addEdge(e4);
		 * G.addEdge(e5); G.addEdge(e6); G.addEdge(e7); G.addEdge(e8);
		 * G.addEdge(e9); G.addEdge(e10); G.addEdge(e11); G.addEdge(e12);
		 * G.addEdge(e13); G.addEdge(e14); G.addEdge(e15); G.addEdge(e16);
		 * G.addEdge(e17); G.addEdge(e18); G.addEdge(e19); G.addEdge(e20);
		 * G.addEdge(e21); G.addEdge(e22); G.addEdge(e23); G.addEdge(e24);
		 * G.addEdge(e25); G.addEdge(e26); G.addEdge(e27); G.addEdge(e28);
		 * G.addEdge(e29); G.addEdge(e30); G.addEdge(e31); G.addEdge(e32);
		 * G.addEdge(e33); G.addEdge(e34); G.addEdge(e35); G.addEdge(e36);
		 * G.addEdge(e37); G.addEdge(e38); G.addEdge(e39); G.addEdge(e40);
		 * G.addEdge(e41); G.addEdge(e42); G.addEdge(e43); G.addEdge(e44);
		 * G.addEdge(e45); G.addEdge(e46); G.addEdge(e47); G.addEdge(e48);
		 * G.addEdge(e49); G.addEdge(e50); G.addEdge(e51); G.addEdge(e52);
		 * G.addEdge(e53); G.addEdge(e54); G.addEdge(e55); G.addEdge(e56);
		 * G.addEdge(e57); G.addEdge(e58); G.addEdge(e59); G.addEdge(e60);
		 * G.addEdge(e61); G.addEdge(e62); G.addEdge(e63); G.addEdge(e64);
		 * G.addEdge(e65); G.addEdge(e66); G.addEdge(e67); G.addEdge(e68);
		 * G.addEdge(e69); G.addEdge(e70);
		 */

		if (G.canShare(e9.right, q, p, G)) {// p can share the right labeled on
											// e9 edge with q in G graph
			System.out.println(p
					+ " can share the rights with " + q
					+ " in G graph");	
	}
		else
			System.out.println(p
					+ " can not share the rights  with " + q
					+ " in G graph");
	}

}
