


import java.util.*;

class GraphNode1 {
    int data;
    List<GraphNode1> nextNodes;

    GraphNode1(int data) {
        this.data = data;
        this.nextNodes = new ArrayList<>();
    }

    void addNextNode(GraphNode1 node) {
        nextNodes.add(node);
    }
}

class DirectedGraph {
    private Map<Integer, GraphNode1> graph;

    DirectedGraph() {
        graph = new HashMap<>();
    }

    void addNode(int data) {
        if (!graph.containsKey(data)) {
            GraphNode1 newNode = new GraphNode1(data);
            graph.put(data, newNode);
        }
    }

    void addEdge(int from, int to) {
        if (graph.containsKey(from) && graph.containsKey(to)) {
            GraphNode1 fromNode = graph.get(from);
            GraphNode1 toNode = graph.get(to);
            fromNode.addNextNode(toNode);
        } else {
            System.out.println("Node not found in the graph.");
        }
    }

    void bfs(int startData) {
        if (!graph.containsKey(startData)) {
            System.out.println("Start node not found in the graph.");
            return;
        }

        GraphNode1 startNode = graph.get(startData);
        Queue<GraphNode1> queue = new LinkedList<>();
        Set<GraphNode1> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        System.out.println("BFS Traversal starting from node " + startData + ":");
        while (!queue.isEmpty()) {
            GraphNode1 currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            for (GraphNode1 nextNode : currentNode.nextNodes) {
                if (!visited.contains(nextNode)) {
                    queue.add(nextNode);
                    visited.add(nextNode);
                }
            }
        }
        System.out.println();
    }
}

public class GraphEg{
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        // Adding nodes to the graph
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        // Adding edges between nodes
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Perform BFS starting from node 1
        graph.bfs(2);
    }
}

