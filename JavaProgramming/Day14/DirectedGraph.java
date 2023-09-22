import java.util.*;
public class DirectedGraph{
    private List<GraphNode> nodes;
    DirectedGraph()
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

        LinkedList<GraphNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Set<GraphNode> visited = new HashSet<>();

        stack.push(startNode);
        visited.add(startNode);

        System.out.println("DFS Traversal starting from node " + startNode.getData() + ":");
        while (!stack.isEmpty()) {
            System.out.println("Stack values: ");
            for(GraphNode val:stack)
            {
                System.out.print(val.getData()+" ");
            }
            System.out.println();
            GraphNode currentNode = stack.pop();
            result.add(currentNode.getData());

            for (GraphNode nextNode : currentNode.getNextNodes()) {
                if (!visited.contains(nextNode)) {
                    stack.push(nextNode);
                    visited.add(nextNode);
                }
            }
        }
        System.out.println(result.toString());
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
        DirectedGraph graph1 = new DirectedGraph();
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

 
 

        // graph1.printGraph();
        // graph1.bfs(2);
        graph1.dfs(2);
    }
}


// import java.util.*;

// class DirectedGraphNode2 {
//     private int data;
//     private List<DirectedGraphNode2> nextNodes;

//     DirectedGraphNode2() {
//         this.nextNodes = new ArrayList<>();
//     }

//     DirectedGraphNode2(int data) {
//         this.data = data;
//         this.nextNodes = new ArrayList<>();
//     }

//     void addData(int data) {
//         this.data = data;
//     }

//     void addNextNode(DirectedGraphNode2 node) {
//         this.nextNodes.add(node);
//     }

//     int getData() {
//         return data;
//     }

//     List<DirectedGraphNode2> getNextNodes() {
//         return nextNodes;
//     }
// }

// public class GraphDemo {
//     static Scanner sc = new Scanner(System.in);

    // public static void bfs(DirectedGraphNode2 startNode) {
    //     if (startNode == null) {
    //         System.out.println("Start node is null.");
    //         return;
    //     }

    //     Queue<DirectedGraphNode2> queue = new LinkedList<>();
    //     Set<DirectedGraphNode2> visited = new HashSet<>();

    //     queue.add(startNode);
    //     visited.add(startNode);

    //     System.out.println("BFS Traversal starting from node " + startNode.getData() + ":");
    //     while (!queue.isEmpty()) {
    //         DirectedGraphNode2 currentNode = queue.poll();
    //         System.out.print(currentNode.getData() + " ");

    //         for (DirectedGraphNode2 nextNode : currentNode.getNextNodes()) {
    //             if (!visited.contains(nextNode)) {
    //                 queue.add(nextNode);
    //                 visited.add(nextNode);
    //             }
    //         }
    //     }
    //     System.out.println();
    // }

//     public static void main(String[] args) {
//         DirectedGraphNode2 node1 = new DirectedGraphNode2(1);
//         DirectedGraphNode2 node2 = new DirectedGraphNode2(2);
//         DirectedGraphNode2 node3 = new DirectedGraphNode2(3);
//         DirectedGraphNode2 node4 = new DirectedGraphNode2(4);

//         node1.addNextNode(node2);
//         node1.addNextNode(node3);
//         node2.addNextNode(node3);
//         node3.addNextNode(node4);

//         // Perform BFS starting from node1
//         bfs(node1);
//     }
// }
