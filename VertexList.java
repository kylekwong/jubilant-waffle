import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.Math;


public class VertexList
{

    /* Use Map collection to store vertex list for each vertex.*/
    private  Map<Integer, List<Double>> Vertex_List;

     /* Initializes map  with size equal to number of vertices in a graph
     * Maps each vertex to a given List Object which will be the coordinates */
    public VertexList(int number_of_vertices, int number_of_coord)
    {
        Vertex_List = new HashMap<Integer, List<Double>>();
        for (int i = 0 ; i < number_of_vertices ; i++)
        {
            Vertex_List.put(i, new ArrayList<Double>(number_of_coord));
        }
    }

    /* Adds nodes in the vertex list for the corresponding vertex */
    public void setCoordinate(int vertex, double  coord)
    {
        if (vertex > Vertex_List.size())
        {
            /*System.out.println("the vertex entered in not present "); */
            return;
        }
        List<Double> vlist = Vertex_List.get(vertex);
        vlist.add(coord);
    }

    /* Returns the List containing the vertex joining the source vertex */
    public List<Double> getCoord(int vertex)
    {
        if (vertex > Vertex_List.size())
        {
            /* System.out.println("the vertex entered is not present"); */
            return null;
        }
        return Vertex_List.get(vertex);
    }

    /* Main Function creates an adjancy list for a complete graph */
    public static VertexList init()
    {
        double coord;

        int number_of_vertices = 10;

        int number_of_coord = 2;

        VertexList vertexList = new VertexList(number_of_vertices, number_of_coord);

        for(int i = 0; i < number_of_vertices; ++i) {
            for (int j = 0; j < number_of_coord; ++j) {
                coord = Math.random();
                vertexList.setCoordinate(i, coord);
            }
        } 
        
        return vertexList;
         /*for (int i = 0 ; i < number_of_vertices ; i++)
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