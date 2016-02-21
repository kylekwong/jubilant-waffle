import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math;

public class PrimsAlg 
{

    AdjacencyList adjacencyList = new AdjacencyList(number_of_vertices);

    public PrimsAlg(int number_of_vertices)
    {
        Adjacency_List = new HashMap<Integer, List<heapNode>>();
        for (int i = 0 ; i < number_of_vertices ; i++)
        {
            Adjacency_List.put(i, new LinkedList<heapNode>());
        }
    }

}