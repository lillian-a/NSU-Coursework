
/* CSIS 3400
 * ASSIGNMENT 9 */
public class Assignment09 {

	public static void main(String[] args) {
		test(new DigraphWithAdjacencies(20), "test1");
		test(new UGraphWithMatrix(20), "test2");
	}

	public static void test(Graph g, String graphname) {
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addEdge("E", "B", 1);
		g.addEdge("A", "B", 1);
		g.addEdge("C", "D", 1);
		g.addEdge("A", "D", 1);
		g.addEdge("B", "D", 1);
		g.printGraphToFile(graphname);
	}

	
	/*		OUTPUT SHOULD BE:
	 * 		----------------
	 * 
	 * 
	 *		digraph test1 {
			A -> D [label=1];
			A -> B [label=1];
			B -> D [label=1];
			C -> D [label=1];
			E -> B [label=1];
			}
			graph test2 {
			B -- A [label=1];
			D -- A [label=1];
			D -- B [label=1];
			D -- C [label=1];
			E -- B [label=1];
			}
	 */
}


