class Solution {
       private int[] topoSort(int V, 
            ArrayList<Integer>[] adj) {    
       
	    int[] inDegree = new int[V];   
	   
		for (int i = 0; i < V; i++) {	    
			for(int it : adj[i]) {		   
			    inDegree[it]++;
			}
		}       
        int[] ans = new int[V];
        int idx = 0;
	    Queue<Integer> q = new LinkedList<>();  
	    for(int i = 0; i < V; i++) {
	        if(inDegree[i] == 0) q.add(i);
	    } 	    
	    while(!q.isEmpty()) {	        
	        int node = q.poll();
            ans[idx++] = node;    
	        for(int it : adj[node]) {            
	            inDegree[it]--;      
	            if(inDegree[it] == 0) q.add(it);
	        }
	    }    
	    
	    return Arrays.copyOfRange(ans, 0, idx);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer> []adj=new ArrayList[numCourses];
        for(int i =0;i<numCourses;i++){
            adj[i]= new ArrayList<>();
        }

        for(int it[]:prerequisites ){
            int u =it[0];
            int v=it[1];
            adj[v].add(u);
        }
        int topo[]=topoSort(numCourses,adj);
        if(topo.length<numCourses) return false;
        return true;
        
    }
}