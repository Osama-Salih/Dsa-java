import dsa.Graph;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("B", "D");
        g.addEdge("C", "E");
        g.addEdge("D","E");
        g.addEdge("D","F");
        g.addEdge("E","F");

//        System.out.println(g.dftRecursive("A"));
//        System.out.println(g.bft("A"));

        g.print();
    }
}