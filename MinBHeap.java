import java.util.Arrays;

/**********
MinBHeap.java
Implentation of Minimum Binary Heap
**********/
 
public class MinBHeap {
    private Vertex[] heap;
    private int[] pos;
    public int heapSize;
    private int posSize;

    // creates new heap
    public MinBHeap(int size) {
        heap = new Vertex[size];
        pos = new int[size];

        // pos[i] == -1 means vertex i is not in heap
        Arrays.fill(pos, -1);
        posSize = size;
        heapSize = 0;
    }

    // inserts new node into heap
    public void insert(Vertex new_node) {
        int index;

        // if new_node is not already in heap
        if (pos[new_node.v] == -1) {
            // insert at end
            heap[heapSize++] = new_node;

            index = heapSize - 1;
            pos[new_node.v] = index;
        } else {
            // if new_node is already in heap
            index = pos[new_node.v];
            heap[index].edge = new_node.edge;
        }

        // swap until it gets to right place
        Vertex node = heap[index];
        while (index > 0 && node.edge < heap[parent(index)].edge) {
            // swap pos 
            pos[new_node.v] = pos[heap[parent(index)].v];
            pos[heap[parent(index)].v] = index;

            // swap edge values
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = node;
    }

    public Vertex deletemin() {
        Vertex min = heap[0];
        pos[heap[0].v] = -1;
        heap[0] = heap[--heapSize];

        // fix heap
        minHeapify(0);
        return min;
    }

    // given a root index, create min heap
    private void minHeapify(int root_index) {
        int smallest;
        int l_index = lChild(root_index);
        int r_index = rChild(root_index);

        // if left child exists and <
        if (l_index < heapSize && heap[l_index].edge < heap[root_index].edge) {
            smallest = l_index;
        } else {
            smallest = root_index;
        }

        // right child exists and <
        if (r_index < heapSize && heap[r_index].edge < heap[smallest].edge) {
            smallest = r_index;
        }

        // if root value is in wrong place, swap and fix
        if (smallest != root_index) {
            // swap pos in pos array
            pos[heap[root_index].v] = pos[heap[smallest].v];
            pos[heap[smallest].v] = root_index;

            Vertex temp = heap[root_index];
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
            System.out.printf("(%d, %f) ", heap[i].v, heap[i].edge);
        }
        System.out.print("\n");
        for (int j = 0; j < posSize; j++) {
            System.out.print(pos[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Testing Purposes
        // MinBHeap mbh = new MinBHeap(5);
        // mbh.insert(new Vertex(0, 4));
        // mbh.insert(new Vertex(1, 3));
        // mbh.insert(new Vertex(2, 1));
        // mbh.insert(new Vertex(3, 0));
        // mbh.insert(new Vertex(4, 2));
        // mbh.insert(new Vertex(4, 0));
        // mbh.printHeap();
    }
}