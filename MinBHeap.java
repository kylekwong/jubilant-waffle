 import java.util.Arrays;

/**********
MinBHeap.java
Implentation of Minimum Binary Heap
**********/
 
public class MinBHeap {
	private int[] heap;
	private int heapSize;

	// creates new heap
	public MinBHeap(int size) {
		heap = new int[size];
		heapSize = 0;
	}

	// inserts new node into heap
	public void insert(int x) {
		// insert at end
		heap[heapSize++] = x;

		int index = heapSize - 1;

		// swap until it gets to right place
		int num = heap[index];
		while (index > 0 && num < heap[parent(index)]) {
			heap[index] = heap[parent(index)];
			index = parent(index);
		}
		heap[index] = num;
	}

	public int deletemin() {
		int min = heap[0];
		heap[0] = heap[heapSize-1];
		heapSize--;
		minHeapify(0);
		return min;
	}

	// given a root index, create min heap
	private void minHeapify(int root_index) {
		int smallest;
		int l_index = lChild(root_index);
		int r_index = rChild(root_index);

		// if left child exists and <
		if (l_index < heapSize && heap[l_index] < heap[root_index]) {
			smallest = l_index;
		} else {
			smallest = root_index;
		}

		// right child exists and <
		if (r_index < heapSize && heap[r_index] < heap[smallest]) {
			smallest = r_index;
		}

		// if root value is in wrong place, swap and fix
		if (smallest != root_index) {
			int temp = heap[root_index];
			heap[root_index] = heap[smallest];
			heap[smallest] = temp;
			minHeapify(smallest);
		}
	}

	// returns index of left child
	private int lChild(int root) {
		return 2 * root + 1;
	}

	// returns index of right child
	private int rChild(int root) {
		return 2 * root + 2;
	}

	// returns index of parent 
	private int parent(int root) {
		return (root - 1) / 2;
	}

	public void printHeap() {
		for (int i = 0; i < heapSize; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// testing bs
		MinBHeap mbh = new MinBHeap(5);
		mbh.insert(3);
		mbh.insert(0);
		mbh.insert(1);
		mbh.insert(5);
		mbh.insert(2);
		mbh.deletemin();
		mbh.deletemin();
		mbh.deletemin();
		mbh.printHeap();
	}
}