import java.util.*;

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];
            if (d > dist[node]) continue;
            for (int[] nbr : adj.get(node)) {
                int next = nbr[0], wt = nbr[1];
                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
        return dist;
    }
}
