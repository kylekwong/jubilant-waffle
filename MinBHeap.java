import java.util.Arrays;

/**********
MinBHeap.java
Implentation of Minimum Binary Heap
**********/
 
public class MinBHeap {
    private Vertex[] heap;
    private int heapSize;

    // creates new heap
    public MinBHeap(int size) {
        heap = new Vertex[size];
        heapSize = 0;
    }

    // inserts new node into heap
    public void insert(Vertex new_node) {
        // insert at end
        heap[heapSize++] = new_node;

        int index = heapSize - 1;

        // swap until it gets to right place
        Vertex node = heap[index];
        while (index > 0 && node.edge < heap[parent(index)].edge) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = node;
    }

    public Vertex deletemin() {
        Vertex min = heap[0];
        heap[0] = heap[--heapSize];
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
            System.out.printf("(%d, %d, %f) ", 
                heap[i].v1, heap[i].v2, heap[i].edge);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Testing Purposes
        // MinBHeap mbh = new MinBHeap(5);
        // mbh.insert(new heapNode(8, 4, 4));
        // mbh.insert(new heapNode(1, 2, 3));
        // mbh.insert(new heapNode(2, 5, 1));
        // mbh.insert(new heapNode(3, 6, 0));
        // mbh.insert(new heapNode(4, 1, 2));
        // mbh.deletemin();
        // mbh.deletemin();
        // mbh.deletemin();
        // mbh.deletemin();
        // mbh.deletemin();
        // mbh.printHeap();
    }
}