// Random MST Java Implementation
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math;

public class randmst {
	public static void main(String args[]) {
		if (args.length != 4) {
			System.out.println("usage: randmst flag numpoints numtrials dimension");
			System.exit(1);
		}

		int flag = Integer.parseInt(args[0]);
		int numpoints = Integer.parseInt(args[1]);
		int numtrials = Integer.parseInt(args[2]);
		int dimension = Integer.parseInt(args[3]);

		AdjacencyList adjacencyList = new AdjacencyList(numpoints);

		adjacencyList = adjacencyList.init(numpoints, dimension);

		// begin Prim's
		double[] dist = new double[numpoints];
		int[] prev = new int[numpoints];

		// s[0] == true means vertex 0 is in S
		boolean[] s = new boolean[numpoints];

		MinBHeap heap = new MinBHeap(numpoints);
		heap.insert(new Vertex(0, 0.0));

		// initialize dist and prev arrays
		for (int i = 0; i < numpoints; i++) {
			dist[i] = Double.MAX_VALUE;
			prev[i] = -1;
		}

		while (heap.heapSize != 0) {
			Vertex v = heap.deletemin(); 

			// adds v to S
			s[v.v] = true;
			List<Vertex> edges_of_v = adjacencyList.getEdge(v.v);

			for(int i = 0; i < numpoints; ++i) {
				// if i not in S
				if (!s[i]) {
					if (dist[i] > edges_of_v.get(i)) {
						dist[i] = edges_of_v.get(i);
						prev[i] = i;
						/* Insert w into heap */
						heap.insert(new Vertex(i, dist[i]));
					}
				}
			}
		}
	}
}