class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    ans.add(node);
                    for (int neighbour : adj.get(node)) {
                        if (!vis[neighbour]) {
                            vis[neighbour] = true;
                            q.add(neighbour);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
