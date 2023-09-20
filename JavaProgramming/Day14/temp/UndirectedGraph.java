import java.util.*;

public class UndirectedGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Add an undirected edge between two vertices
    public void addEdge(int vertex1, int vertex2) {
        if (!adjacencyList.containsKey(vertex1)) {
            addVertex(vertex1);
        }
        if (!adjacencyList.containsKey(vertex2)) {
            addVertex(vertex2);
        }
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    // Print the graph
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int vertex = entry.getKey();
            List<Integer> neighbors = entry.getValue();
            System.out.print("Vertex " + vertex + " is connected to: ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Undirected Graph structure:");
        graph.printGraph();
    }
}
