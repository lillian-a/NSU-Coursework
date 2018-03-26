/* CSIS 3400
 * ASSIGNMENT 9 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UGraphWithMatrix extends Graph {
	Vertex vertices[];
	int edgeMatrix[][];
	private int numberOfVertices;

	class Vertex {
		String label;
		boolean visited;

		Vertex(String label) {
			this.label = label;
			visited = false;
		}
	}

	public UGraphWithMatrix(int size) {
		vertices = new Vertex[size];
		edgeMatrix = new int[size][size];
		numberOfVertices = 0;
		// initially there are no edges
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				edgeMatrix[i][j] = 0;
		}
	}

	@Override
	boolean addVertex(String label) {
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
	void addEdge(String sourceLabel, String destinationLabel, int weight) {
		// TODO add your code here
		// find both vertex indexes, add weight to matrix for both directions
		int u = findVertexIndex(sourceLabel);
		int v = findVertexIndex(destinationLabel);
		edgeMatrix[u][v] = weight;
		edgeMatrix[v][u] = weight;
		
	}

	private int findVertexIndex(String label) {
		// DONE 4-25-17 - dbl check on compareTo method
		// TODO add your code here (and use in in the addEdge method)
		// find the vertex index in vertices array by comparing labels
		for(int i = 0; i < vertices.length; i++) {
			if (vertices[i].label.compareTo(label) == 0) {
				// found
				return i;
			}
		}
		// not found
		return -1;
	}

	@Override
	boolean printGraphToFile(String graphname) {
		try {
			PrintWriter pWriter = new PrintWriter(graphname + ".txt");
			pWriter.println("graph " + graphname + " {");
			for (int i = 0; i < numberOfVertices; i++) {
				for (int j = 0; j < i; j++) {
					int weight = edgeMatrix[i][j];
					if (weight > 0) {
						pWriter.println(vertices[i].label + " -- "
								+ vertices[j].label + " [label=" + weight
								+ "];");
					}
				}
			}
			pWriter.println("}");
			pWriter.close();
			System.out.println("Use this line to draw the undirected graph");
			System.out.println("dot -Tpdf " + graphname + ".txt -o "
					+ graphname + ".pdf");
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
