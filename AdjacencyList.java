import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdjacencyList
{
    /* Use Map collection to store adjacency list for each vertex.*/
    private  Map<Integer, List<Integer>> Adjacency_List;

     /* Initializes map  with size equal to number of vertices in a graph
     * Maps each vertex to a given List Object */

    public AdjacencyList(int number_of_vertices)
    {
        Adjacency_List = new HashMap<Integer, List<Integer>>();
        for (int i = 0 ; i < number_of_vertices ; i++)
        {
            Adjacency_List.put(i, new LinkedList<Integer>());
        }
    }


    /* Adds nodes in the Adjacency list for the corresponding vertex */
    public void setEdge(int source , int destination)
    {
        if (source > Adjacency_List.size() || destination > Adjacency_List.size())
        {
            /*System.out.println("the vertex entered in not present "); */
            return;
        }
        List<Integer> slist = Adjacency_List.get(source);
        slist.add(destination);
        List<Integer> dlist = Adjacency_List.get(destination);
        dlist.add(source);
    }

    /* Returns the List containing the vertex joining the source vertex */
    public List<Integer> getEdge(int source)
    {
        if (source > Adjacency_List.size())
        {
            /* System.out.println("the vertex entered is not present"); */
            return null;
        }
        return Adjacency_List.get(source);
    }

    /* Main Function creates an adjancy list for a complete graph */
    public static void main(String...arg)
    {
        int source, destination;

        int number_of_vertices = 10;
        
        AdjacencyList adjacencyList = new AdjacencyList(number_of_vertices);

        for(int i = 0; i < number_of_vertices; ++i) {
            for (int j = i + 1; j < number_of_vertices; ++j) {
                source = i;
                destination = j;
                adjacencyList.setEdge(source, destination);
            }
        } 

         for (int i = 0 ; i < number_of_vertices ; i++)
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
          }
    }
}