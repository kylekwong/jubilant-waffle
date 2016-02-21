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


	}
}