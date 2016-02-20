#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// TODO: Adjacency list implementation 

int main(int argc, char* argv[]) {
    if (argc != 5) {
        printf("Usage: randmst 0 numpoints numtrials dimension\n");
        return 1;
    }

    int numpoints = atoi(argv[2]);

    // TODO: Heap functions

    // TODO: Prim's Algorithm Implementation

    int dist[numpoints];
    // (type to be defined) prev[numpoints];
    
    // set of vertices (adjacency list?), initially empty

    // priority heap of V
    int heapsize = 0;
    // H := {s: 0}

    for (int i = 0; i < numpoints; i++) {
        dist[i] = INT_MAX;
    }

    dist[0] = 0;

    while (heapsize != 0) {
        // node = deletemin(H)
        // append vertex to S
        // 
    }

}