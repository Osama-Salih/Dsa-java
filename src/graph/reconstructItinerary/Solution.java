package graph.reconstructItinerary;

import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        List<String> itinerary = new ArrayList<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.putIfAbsent(from, new PriorityQueue<>());
            adj.get(from).offer(to);
        }
        dfs("JFK", itinerary, adj);
        Collections.reverse(itinerary);
        return itinerary;
    }
    private void dfs(String node, List<String> itinerary, Map<String, PriorityQueue<String>> adj){
        PriorityQueue<String> pq = adj.get(node);
        while(pq != null && !pq.isEmpty()) {
            String adjNode = pq.poll();
            dfs(adjNode, itinerary, adj);
        }
        itinerary.add(node);
    }
}
// t = O(E log E)
// s = O(E)