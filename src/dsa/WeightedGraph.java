package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {

    private Map<String, List<Edge>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        if (!this.adjacencyList.containsKey(vertex))
            this.adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2, int weight) {
        this.adjacencyList.get(vertex1).add(new Edge(vertex2, weight));
        this.adjacencyList.get(vertex2).add(new Edge(vertex1, weight));
    }

    public List<String> shortestPath(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue queue = new PriorityQueue();
        List<String> path = new ArrayList<>();
        String smallest = "";

        for(String key : adjacencyList.keySet()) {
           if (key.equals(start)) {
               distances.put(key, 0);
               queue.enqueue(key, 0);
           } else {
               distances.put(key, Integer.MAX_VALUE);
               queue.enqueue(key, Integer.MAX_VALUE);
           }
            previous.put(key, null);
        }

        while(!queue.heap.isEmpty()) {
           smallest = queue.dequeue().val;
           if (smallest.equals(end)) {
               while(previous.get(smallest) != null) {
                   path.add(smallest);
                   smallest = previous.get(smallest);
               }
               break;
           }

           List<Edge> neighbors = this.adjacencyList.get(smallest);
           if (neighbors != null) {
               for(Edge edge : neighbors) {
                   int newDist = distances.get(smallest) + edge.weight;
                   if (newDist < distances.get(edge.node)) {
                       distances.put(edge.node, newDist);
                       previous.put(edge.node, smallest);
                       queue.enqueue(edge.node, newDist);
                   }
               }
           }
        }
        path.add(smallest);
        path = path.reversed();
        return path;
    }
}