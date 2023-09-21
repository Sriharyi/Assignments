import java.util.*;
public class UnDirectedGraph{
    private List<GraphNode> nodes;
    UnDirectedGraph()
    {
        nodes = new ArrayList<>();
    }
    public void addVertextoGraph(int val)
    {
       GraphNode newNode = new GraphNode();
       newNode.addData(val);
       nodes.add(newNode);
    }
    public void addEdgetoGraph(int from,int to)
    {
        GraphNode vertex1 = findNode(from);
        GraphNode vertex2 = findNode(to);
        if(vertex1 != null && vertex2!=null)
        {
            vertex1.addNextNode(vertex2);
            vertex2.addNextNode(vertex1);
        }else{
            System.out.println("vertex cannot be found");
        }
    }
    
    public GraphNode findNode(int key) {
        for(GraphNode node:nodes)
        {
            if(node.getData()==key)
            {
                return node;
            }
        }
        return null;
    }
     public void bfs(int startNodeval) {
        GraphNode startNode = findNode(startNodeval);
        if(startNode!=null)
        {
            bfs(startNode);
        }
        else{
            System.out.println("StartNode is not found");
        }
     }

     public void bfs(GraphNode startNode) {
        if (startNode == null) {
            System.out.println("Start node is null.");
            return;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        System.out.println("BFS Traversal starting from node " + startNode.getData() + ":");
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            System.out.print(currentNode.getData() + " ");

            for (GraphNode nextNode : currentNode.getNextNodes()) {
                if (!visited.contains(nextNode)) {
                    queue.add(nextNode);
                    visited.add(nextNode);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int startNodeval)
    {
        GraphNode startNode = findNode(startNodeval);
        if(startNode!=null)
        {
            dfs(startNode);
        }
        else{
            System.out.println("StartNode is not found");
        }
    }
    public void dfs(GraphNode startNode)
    {
         if (startNode == null) {
            System.out.println("Start node is null.");
            return;
        }

        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> visited = new HashSet<>();

        stack.push(startNode);
        visited.add(startNode);

        System.out.println("DFS Traversal starting from node " + startNode.getData() + ":");
        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            System.out.print(currentNode.getData() + " ");

            for (GraphNode nextNode : currentNode.getNextNodes()) {
                if (!visited.contains(nextNode)) {
                    stack.push(nextNode);
                    visited.add(nextNode);
                }
            }
        }
        System.out.println();
    }
    public void printGraph() {
        for (GraphNode node:nodes) {
            int vertex = node.getData();
            List<GraphNode> neighbors = node.getNextNodes();
            System.out.print("Vertex " + vertex + " is connected to: ");
            for (GraphNode neighbor : neighbors) {
                System.out.print(neighbor.getData() + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        UnDirectedGraph graph1 = new UnDirectedGraph();
        graph1.addVertextoGraph(1);
        graph1.addVertextoGraph(2);
        graph1.addVertextoGraph(3);
        graph1.addVertextoGraph(4);
        graph1.addVertextoGraph(5);

        graph1.addEdgetoGraph(1, 2);
        graph1.addEdgetoGraph(1, 3);
        graph1.addEdgetoGraph(2, 3);
        graph1.addEdgetoGraph(3, 4);
        graph1.addEdgetoGraph(3, 5);
        graph1.addEdgetoGraph(4, 5);

        graph1.printGraph();
        graph1.bfs(2);
        graph1.dfs(2);
    }
}
