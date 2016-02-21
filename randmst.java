// Random MST Java Implementation

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

		adjacencyList = adjacencyList.init(numpoints, dimension)

		// begin Prim's
		int[] dist = new int[numpoints];
		int[] prev = new int[numpoints];

		int[] s = new int[numpoints];
		MinBHeap heap = new MinBHeap(numpoints*numpoints);
		heap.insert(new heapNode(0, 0, 0));

		while (heap.heapSize != 0) {
			Vertex v = heap.deletemin(); */
			/* Add v to S */
			List<Double> edges_of_v = adjacencyList.getEdge(v);

			for(int i = 0; i < numpoints; ++i) {
				/* if i not in S*/
				if (dist[i] > edges_of_v.get(i)) {
					dist[i] = edges_of_v.get(i);
					prev[i] = i;
					/* Insert w into heap */
				}

			}

		}

	}
}