import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    HashMap<Node,LinkedList<Node>> adjacencyMap;
    boolean directed;
    
    public Graph(boolean dir){
        adjacencyMap = new HashMap<Node,LinkedList<Node>> ();
        directed = dir;
    }
    public void insertEdge(Node Source,Node Desti){
        if(!adjacencyMap.keySet().contains(Source)){
            LinkedList<Node> temp = new LinkedList();
            temp.add(Desti);
            adjacencyMap.put(Source, temp);
        }else{
            LinkedList<Node> temp = adjacencyMap.get(Source);
            temp.add(Desti);
            adjacencyMap.put(Source, temp);
        }
    }
    
    public HashMap<Node,LinkedList<Node>> getAdjacencyMap(){
        return adjacencyMap;
    }
    
    public void printEdge(){
        for(Node n: adjacencyMap.keySet()){
            System.out.print(n.getName() + ":");
            for(Node desti:adjacencyMap.get(n)){
                System.out.print(desti.getName()+ ",");
            }
            System.out.print("\n");
        }
    }
}
