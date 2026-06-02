package dsa.graph.graphRepresentation;

public class UndirectedGraphAdjacencyMatrix {
   private int V; // number of vertices
   private int E; // number of edges
   private int[][] adjMatrix;

   public UndirectedGraphAdjacencyMatrix(int nodes) {
       this.V = nodes;
       this.E = 0;
       this.adjMatrix = new int[nodes][nodes];
   }

   public void addEdge(int u, int v) {
       if (adjMatrix[u][v] != 1){
           E++;
       }
       adjMatrix[u][v] = 1;
       adjMatrix[v][u] = 1; // because the graph is an undirected
   }

   public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(V + " vertices " + E + " Edges " + "\n");
       for (int v = 0; v < V; v++) {
           sb.append(v + ": ");
           for (int w : adjMatrix[v]) {
               sb.append(w + " ");
           }
           sb.append("\n");
       }
       return sb.toString();
   }

    public static void main(String[] args) {
        UndirectedGraphAdjacencyMatrix g = new UndirectedGraphAdjacencyMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        System.out.println(g);

    }
}
