// Random MST Java Implementation
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math;
import java.util.Arrays;

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

		double avg_weight = 0.0;

		double maxLength = 0; 

		if (flag == 0) {
			for (int n = 0; n < numtrials; n++) {
				// add to final weight of MST
				double weight = 0.0;
				AdjacencyList adjacencyList = new AdjacencyList(numpoints);

				adjacencyList = adjacencyList.init(numpoints, dimension);

				// begin Prim's
				double[] dist = new double[numpoints];
				int[] prev = new int[numpoints];

				// s[0] == true means vertex 0 is in S
				boolean[] s = new boolean[numpoints];
				Arrays.fill(s, false);

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
					weight += v.edge;
					if (v.edge > maxLength) {
						maxLength = v.edge;
					}

					List<Vertex> edges_of_v = adjacencyList.getEdge(v.v);

					for(Vertex w : edges_of_v) {
						// if i not in S
						if (!s[w.v]) {
							if (dist[w.v] > w.edge) {
								dist[w.v] = w.edge;
								prev[w.v] = w.v;
								/* Insert w into heap */
								heap.insert(new Vertex(w.v, dist[w.v]));

							}
						}
					}
				}
				avg_weight += weight;
			}
			avg_weight /= numtrials;
			System.out.printf("%f %d %d %d %f\n", avg_weight, numpoints, 
				numtrials, dimension, maxLength);

		}

		else if (flag == 1) {
			while (numpoints <= 65536) {
				maxLength = 0;
				for (int n = 0; n < numtrials; n++) {
					// add to final weight of MST
					double weight = 0.0;
					AdjacencyList adjacencyList = new AdjacencyList(numpoints);

					adjacencyList = adjacencyList.init(numpoints, dimension);

					// begin Prim's
					double[] dist = new double[numpoints];
					int[] prev = new int[numpoints];

					// s[0] == true means vertex 0 is in S
					boolean[] s = new boolean[numpoints];
					Arrays.fill(s, false);

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
						weight += v.edge;
						if (v.edge > maxLength) {
							maxLength = v.edge;
						}

						List<Vertex> edges_of_v = adjacencyList.getEdge(v.v);

						for(Vertex w : edges_of_v) {
							// if i not in S
							if (!s[w.v]) {
								if (dist[w.v] > w.edge) {
									dist[w.v] = w.edge;
									prev[w.v] = w.v;
									/* Insert w into heap */
									heap.insert(new Vertex(w.v, dist[w.v]));

								}
							}
						}
					}
					avg_weight += weight;
				}
				avg_weight /= numtrials;
				System.out.printf("%f %d %d %d %f\n", avg_weight, numpoints, 
					numtrials, dimension, maxLength);

				numpoints *= 2;
			}
		}
	}
}