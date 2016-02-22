randmst: *.java
	javac randmst.java
	javac AdjacencyList.java
	javac MinBHeap.java
	javac Vertex.java
	javac VertexList.java

clean:
	$(RM) *.class

.PHONY: all randmst clean