import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VertexList
{
    /* Use Map collection to store adjacency list for each vertex.*/
    private  Map<Integer, List<Integer>> Vertex_List;

     /* Initializes map  with size equal to number of vertices in a graph
     * Maps each vertex to a given List Object which will be the coordinates */
    public AdjacencyList(int number_of_vertices, int number_of_coord)
    {
        Vertex_List = new HashMap<Integer, List<Integer>>();
        for (int i = 0 ; i < number_of_vertices ; i++)
        {
            Vertex_List.put(i, new ArrayList<Integer>(number_of_coord));
        }
    }

    /* Adds nodes in the Adjacency list for the corresponding vertex */
    public void setCoordinate(int vertex, int coord)
    {
        if (source > Vertex_List.size() || destination > Vertex_List.size())
        {
            /*System.out.println("the vertex entered in not present "); */
            return;
        }
        List<Integer> vlist = Vertex_List.get(vertex);
        vlist.add(coord);
    }

    /* Returns the List containing the vertex joining the source vertex */
    public List<Integer> getEdge(int vertex)
    {
        if (source > Vertex_List.size())
        {
            /* System.out.println("the vertex entered is not present"); */
            return null;
        }
        return Vertex_List.get(vertex);
    }

    /* Main Function creates an adjancy list for a complete graph */
    public static void main(String...arg)
    {
        int coord;

        int number_of_vertices = 10;

        int number_of_coord = 2;

        AdjacencyList adjacencyList = new AdjacencyList(number_of_vertices, number_of_coord);

        for(int i = 0; i < number_of_vertices; ++i) {
            for (int j = 0; j < number_of_coord; ++j) {
                coord = ?;
                adjacencyList.setEdge(i, coord);
            }
        } 

         /* for (int i = 0 ; i < number_of_vertices ; i++)
         {
             System.out.print(i+"->");
             List<Integer> edgeList = adjacencyList.getEdge(i);
             for (int j = 0 ; ; j++ )
             {
                 if (j != edgeList.size())
                 {
                     System.out.print(edgeList.get(j)+"->");
                 }else
                 {
                     System.out.print(edgeList.get(j));
                     break;
                 }                       
             }
             System.out.println();                  
          } */
    }
}