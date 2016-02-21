import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math;

public class PrimsAlg 
{

    public PrimsAlg(int int number_of_vertices)
    {
        Adjacency_List = new HashMap<Integer, List<heapNode>>();
        for (int i = 0 ; i < number_of_vertices ; i++)
        {
            Adjacency_List.put(i, new LinkedList<heapNode>());
        }
    }

}