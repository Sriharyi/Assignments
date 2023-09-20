import java.util.*;

public class GraphNode {
    private int data;
    private List<GraphNode> nextNodes;
    GraphNode(){
        nextNodes = new ArrayList<>();
    }
    GraphNode(int value)
    {
        this.data = value;
        this.nextNodes = new ArrayList<>();
    }
    void addNextNode(GraphNode newNode)
    {
        nextNodes.add(newNode);
    }
    void addData(int value)
    {
        this.data = value;
    }
    List<GraphNode> getNextNodes()
    {
        return nextNodes;
    }
    int getData(){
        return data;
    }
}












