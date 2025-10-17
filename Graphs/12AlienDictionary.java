import java.util.*;

class Solution {
    private List<Integer>[] createAdjList(int k) {
        List<Integer>[] adj = new ArrayList[k];
        for (int i = 0; i < k; i++) adj[i] = new ArrayList<>();
        return adj;
    }

    private List<Integer> topoSort(int V, List<Integer>[] adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) for (int it : adj[i]) inDegree[it]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (inDegree[i] == 0) q.add(i);
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int it : adj[node]) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        return topo;
    }

    public String findOrder(String[] words) {
        int n = words.length;
        int k = 26;
        List<Integer>[] adj = createAdjList(k);
        boolean[] seen = new boolean[k];
        for (String w : words) for (char c : w.toCharArray()) seen[c - 'a'] = true;
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj[s1.charAt(j) - 'a'].add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
    List<Integer> topo = topoSort(k, adj);
        StringBuilder ans = new StringBuilder();
        for (int x : topo) if (seen[x]) ans.append((char) ('a' + x));
        return ans.toString();
    }
}
