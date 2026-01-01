import dsa.WeightedGraph;

public class Main {
    public static void main(String[] args) {
        WeightedGraph wg = new WeightedGraph();
        wg.addVertex("A");
        wg.addVertex("B");
        wg.addVertex("C");
        wg.addVertex("D");
        wg.addVertex("E");
        wg.addVertex("F");


        wg.addEdge("A", "B", 4);
        wg.addEdge("A", "C", 2);
        wg.addEdge("B", "E", 3);
        wg.addEdge("C", "D", 2);
        wg.addEdge("C", "F", 4);
        wg.addEdge("D", "E", 3);
        wg.addEdge("D", "F", 1);
        wg.addEdge("E", "F", 1);

        System.out.println(wg.shortestPath("A", "E"));
    }
}