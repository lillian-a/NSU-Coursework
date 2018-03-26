/* CSIS 3400
 * ASSIGNMENT 9 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class DigraphWithAdjacencies extends Graph {
	private Vertex vertices[];
	private int numberOfVertices;

	class Vertex {
		String label;
		Edge adjacencies;
		boolean visited;

		Vertex(String label) {
			this.label = label;
			adjacencies = null;
			visited = false;
		}

		public void addEdge(Edge newNeighbor) {
			// DONE 4-25-17
			// TODO add your code here
			// insert newNeighbor at head of adjacencies linked list
			// if has edges set newNeighbor next to adjacencies
			if (adjacencies != null)
				newNeighbor.next = adjacencies;
			// set adjacencies head to newNeighbor
			adjacencies = newNeighbor;
			
		}
	}

	class Edge {

		Vertex sourceVertex;
		Vertex destinationVertex;
		int weight;
		Edge next;

		Edge(Vertex sourceVertex, Vertex destinationVertex, int weight) {
			this.sourceVertex = sourceVertex;
			this.destinationVertex = destinationVertex;
			this.weight = weight;
			next = null;
		}
	}

	// constructor
	//
	public DigraphWithAdjacencies(int size) {
		vertices = new Vertex[size];
		numberOfVertices = 0;
	}

	@Override
	public boolean addVertex(String label) {
		// DONE 4-25-17
		// TODO add your code here
		// create new Vertex with argument label and add it to the vertices
		if (numberOfVertices < vertices.length) {
			Vertex v = new Vertex(label);
			vertices[numberOfVertices] = v;
			numberOfVertices++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addEdge(String sourceLabel, String destinationLabel, int weight) {
		// DONE 4-25-17 - not positive if this will run bc of too much in one line
		// TODO add your code here
		// find both vertexes, create new edge, and add edge to source vertex
		// Vertex u = findVertex(sourceLabel);
		// Vertex v = findVertex(destinationLabel);
		// Edge e = new Edge(findVertex(sourceLabel), findVertex(destinationLabel), weight);
		// OR Edge e = new Edge(u, v, weight);
		// u.addEdge(e);
		findVertex(sourceLabel).addEdge(new Edge(findVertex(sourceLabel), findVertex(destinationLabel), weight));
	}

	private Vertex findVertex(String label) {
		// DONE 4-25-17 - dbl check on compareTo method
		// TODO add your code here (and use in in the addEdge method)
		// find the Vertex in vertices by comparing labels
		for(int i = 0; i < vertices.length; i++) {
			if (vertices[i].label.compareTo(label) == 0) {
				// found
				return vertices[i];
			}
		}
		// not found
		return null;
	}

	@Override
	boolean printGraphToFile(String graphname) {
		try {
			PrintWriter pWriter = new PrintWriter(graphname + ".txt");
			pWriter.println("digraph " + graphname + " {");
			for (int i = 0; i < numberOfVertices; i++) {
				Edge e = vertices[i].adjacencies;
				while (e != null) {
					pWriter.println(e.sourceVertex.label + " -> "
							+ e.destinationVertex.label + " [label=" + e.weight
							+ "];");
					e = e.next;
				}
			}
			pWriter.println("}");
			pWriter.close();
			System.out.println("Use this line to draw the directed graph:");
			System.out.println("dot -Tpdf " + graphname + ".txt -o "
					+ graphname + ".pdf");
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
