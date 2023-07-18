public class Node {
    int nodeID;
    String name;
    boolean visited;

    public Node(int id, String city) {
        nodeID = id;
        name = city;
        visited = false;
    }

    public String getName() {
        return name;
    }

    public void visit() {
        visited = true;
    }

    public boolean isVisited() {
        return visited;
    }
}
