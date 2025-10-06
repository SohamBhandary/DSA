class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        dfsHelper(0, adj, vis, ans);
        return ans;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        vis[node] = true;
        ans.add(node);
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfsHelper(neighbor, adj, vis, ans);
            }
        }
    }
}
