class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        List<Integer>[] adjRev=new ArrayList[V];
        for(int i=0;i<V;i++) adjRev[i]=new ArrayList<>();
        int[] inDegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:graph[i]){
                adjRev[it].add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++) if(inDegree[i]==0) q.add(i);
        boolean[] safe=new boolean[V];
        while(!q.isEmpty()){
            int node=q.poll();
            safe[node]=true;
            for(int it:adjRev[node]){
                inDegree[it]--;
                if(inDegree[it]==0) q.add(it);
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<V;i++) if(safe[i]) result.add(i);
        return result;
    }
}
