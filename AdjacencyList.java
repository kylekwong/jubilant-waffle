import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math;

public class AdjacencyList
{
     /* Use Map collection to store adjacency list for each vertex.*/
    private Map<Integer, List<Vertex>> Adjacency_List;

     /* Initializes map  with size equal to number of vertices in a graph
     * Maps each vertex to a given List Object */

    public AdjacencyList(int number_of_vertices)
    {
        Adjacency_List = new HashMap<Integer, List<Vertex>>();
        for (int i = 0 ; i < number_of_vertices ; i++)
        {
            Adjacency_List.put(i, new LinkedList<Vertex>());
        }
    }

    /* Adds nodes in the Adjacency list for the corresponding vertex */
    public void setEdge(int source , int destination, VertexList vertexList, int number_of_coord, int number_of_vertices)
    {
        if (source > Adjacency_List.size() || destination > Adjacency_List.size())
        {
            /*System.out.println("the vertex entered in not present "); */
            return;
        }
            double edge; 
            List<Vertex> slist = Adjacency_List.get(source);
            List<Vertex> dlist = Adjacency_List.get(destination);
        
        if (number_of_coord != 0) {
            List<Double> scoord = vertexList.getCoord(source);
            List<Double> dcoord = vertexList.getCoord(destination);

            double square_sum = 0;
            for (int i = 0; i < number_of_coord; ++i) {
                square_sum += Math.pow((scoord.get(i)- dcoord.get(i)),2);
            }

            edge = Math.sqrt(square_sum);
        } else {
            edge = Math.random();
        }
        
        if (number_of_vertices > 4096) {
            if (edge < 0.05) {
                Vertex vertex1 = new Vertex(destination, edge);
                slist.add(vertex1);
                Vertex vertex2 = new Vertex(source, edge);
                dlist.add(vertex2);
            }
        }
        else if (number_of_vertices > 512) {
            if (edge < 0.1) {
                Vertex vertex1 = new Vertex(destination, edge);
                slist.add(vertex1);
                Vertex vertex2 = new Vertex(source, edge);
                dlist.add(vertex2);
            }
        } else { 
            Vertex vertex1 = new Vertex(destination, edge);
            slist.add(vertex1);
            Vertex vertex2 = new Vertex(source, edge);
            dlist.add(vertex2);
        }
    }

    /* Returns the List containing the vertex joining the source vertex */
    public List<Vertex> getEdge(int source)
    {
        if (source > Adjacency_List.size())
        {
            /* System.out.println("the vertex entered is not present"); */
            return null;
        }
        return Adjacency_List.get(source);
    }

    /* Main Function creates an adjancy list for a complete graph */
    public static AdjacencyList init(int number_of_vertices, int number_of_coord)
    {
        int source, destination;

        VertexList vertexList = new VertexList(number_of_vertices, number_of_coord);

        vertexList = vertexList.init(number_of_vertices, number_of_coord);
        
        AdjacencyList adjacencyList = new AdjacencyList(number_of_vertices);

        for(int i = 0; i < number_of_vertices; ++i) {
            for (int j = i + 1; j < number_of_vertices; ++j) {
                source = i;
                destination = j;
                adjacencyList.setEdge(source, destination, vertexList, number_of_coord, number_of_vertices);
            }
        } 
        
        return adjacencyList;

    /*   Testing purposes only

        for (int i = 0 ; i < number_of_vertices; i++)
         {
             List<Vertex> edgeList = adjacencyList.getEdge(i);
             for (int j = 0 ; j < number_of_vertices - 1; j++ )
             {
                    if (j != number_of_vertices - 2)
                    {
                        Vertex vertex = edgeList.get(j);
                        System.out.print(vertex.edge + ", ");
                    } else 
                    {
                        Vertex vertex = edgeList.get(j);
                        System.out.print(vertex.edge);
                    }              
             }
             System.out.println();                  
        } 

        for (int i = 0 ; i < number_of_vertices ; i++)
         {
             List<Double> edgeList = vertexList.getCoord(i);
             for (int j = 0 ; j < number_of_coord ; j++ )
             {
                 if (j != number_of_coord - 1)
                 {
                     System.out.print(edgeList.get(j)+", ");
                 } else
                 {
                     System.out.print(edgeList.get(j));
                     break;
                 }                       
             }
             System.out.println();                  
          } */
    }
}