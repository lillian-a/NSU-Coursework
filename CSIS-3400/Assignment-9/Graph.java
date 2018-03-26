/* CSIS 3400
 * ASSIGNMENT 9 */
public abstract class Graph {
	abstract boolean addVertex(String label);

	abstract void addEdge(String sourceLabel, String destinationLabel,
			int weight);

	abstract boolean printGraphToFile(String graphname);
}