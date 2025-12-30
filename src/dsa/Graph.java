package dsa;

import java.util.*;

public class Graph {

    private Map<String,List<String>> adjacencyList;

    public Graph() {
         this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String name) {
        if (!this.adjacencyList.containsKey(name))
            this.adjacencyList.put(name, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2) {
        this.adjacencyList.get(vertex1).add(vertex2);
        this.adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeEdges(String v1, String v2) {
        this.adjacencyList.get(v1).remove(v2);
        this.adjacencyList.get(v2).remove(v1);
    }

    public void removeVertex(String v) {
        while(!this.adjacencyList.get(v).isEmpty()) {
           String adjacentVertex = this.adjacencyList.get(v).getLast();
           removeEdges(v, adjacentVertex);
        }
        this.adjacencyList.remove(v);
    }

    public List<String> dftRecursive(String vertex) {
        List<String> results = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dft(vertex, results, visited);
//        dftIterative(vertex, results, visited);
        return results;
    }
    private void dft(String vertex, List<String> results, Set<String> visited) {
        if (vertex == null) return;

        visited.add(vertex);
        results.add(vertex);

        List<String> neighbors = adjacencyList.get(vertex);
        if (neighbors.isEmpty()) return;

        for (String value : neighbors) {
            if (!visited.contains(value)) {
                dft(value, results, visited);
            }
        }
    }

    private void dftIterative(String vertex, List<String> results, Set<String> visited){
        if (vertex == null) return;

        Stack<String> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                results.add(vertex);

                List<String> neighbors = this.adjacencyList.get(vertex);
                if (neighbors.isEmpty()) return;

                for (String value : neighbors) {
                    stack.push(value);
                }
            }
        }
    }

    public List<String> bft(String vertex) {
        if (vertex == null) return null;

        Queue<String> queue = new LinkedList<>();
        List<String> results = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        queue.add(vertex);
        while(!queue.isEmpty()) {
            vertex = queue.poll();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                results.add(vertex);

                List<String> neighbors = this.adjacencyList.get(vertex);
                if (neighbors.isEmpty()) return null;

                for (String value : neighbors) {
                    queue.offer(value);
                }
            }
        }
        return results;
    }
}
