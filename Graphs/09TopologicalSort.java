class Solution{
    public static ArrayList<Integer> topoSort(int V,int[][] edges){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e:edges) adj.get(e[0]).add(e[1]);
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)) inDegree[it]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) if(inDegree[i]==0) q.add(i);
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.add(it);
            }
        }
        return ans;
    }
}
