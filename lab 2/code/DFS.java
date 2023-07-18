/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user23
 */
import java.util.HashMap;
import java.util.LinkedList;

public class DFS {
    public void dfs(Node n, Graph g){
        n.visit();
        System.out.print(n.getName()+",");
      


        LinkedList <Node> neg = g.getAdjacencyMap().get(n);
        if(neg==null)
            return;
        else{
            for(Node w:g.getAdjacencyMap().get(n)){
                if(!w.isVisited())
                    dfs(w,g);
            }
        }
          
          
        


    }
    public static void main(String[] args){
        Graph g = new Graph(false);
        
        Node n1 = new Node(1,"Arad");
        Node n2 = new Node(2,"Sibiu");
        Node n3 = new Node(4,"Timisoara");
        //Node n4 = new Node(2,"Zerind");
        //Node n5 = new Node(3,"Oradea");

        
        g.insertEdge(n1,n2);        
        g.insertEdge(n1,n3);        
        g.insertEdge(n2,n3);        
//        g.insertEdge(n3,n1);



        g.printEdge();
        
        DFS d = new DFS();
        d.dfs(n1,g);
    
    }
}


