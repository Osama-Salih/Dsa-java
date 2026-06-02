package dsa.graph.graphRepresentation;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphAdjacencyList {
    private boolean[] visited;
    private static int[] compId;
    private static int count;

    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public UndirectedGraphAdjacencyList(int nodes) {
        V = nodes;
        E = 0;
        adj = new LinkedList[nodes];

        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void bfs(int s) {
        visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");

            for (int w : adj[u]) {
                if (!visited[w]) {
                    visited[w] = true;
                    q.offer(w);
                }
            }
        }

    }

//    // Iterative traversal
//    public void dfs(int s) {
//        visited = new boolean[V];
//        Stack<Integer> stack = new Stack<>();
//        stack.push(s);
//
//        while(!stack.isEmpty()) {
//            int u = stack.pop();
//            if (!visited[u]) {
//                visited[u] = true;
//                System.out.print(u + " ");
//
//                for (int v : adj[u]) {
//                    if (!visited[v]) {
//                        stack.push(v);
//                    }
//                }
//            }
//        }
//    }

    // Recursive traversal
//    public void dfs() {
//        visited = new boolean[V];
//        for (int v = 0; v < V; v++){
//            if (!visited[v]) {
//                dfs(v);
//            }
//        }
//    }
//    private void dfs(int v) {
//        visited[v] = true;
//        System.out.print(v);
//
//        for (int w : adj[v]) {
//            if (!visited[w]) {
//                dfs(w);
//            }
//        }
//    }


    public void dfs() {
       visited = new boolean[V];
       compId = new int[V];
       count = 0;

       for (int v = 0; v < V; v++) {
           if (!visited[v]) {
              dfs(v);
              count++;
           }
       }
    }
    private void dfs(int v) {
        visited[v] = true;
        compId[v] = count;

        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }
    private int getCount() {
        return count;
    }
    private boolean isConnected(int x, int y) {
        return compId[x] == compId[y];
    }

    public static void main(String[] args) {
        UndirectedGraphAdjacencyList g = new UndirectedGraphAdjacencyList(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
//        g.bfs(0);
          g.dfs();
        System.out.println(g.getCount());
        System.out.println(g.isConnected(5, 4));
    }
}
