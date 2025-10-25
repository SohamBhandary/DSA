class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>>graph= new HashMap<>();
        for(int []edge:times){
            graph.computeIfAbsent(edge[0],x->new ArrayList<>()).add(new int []{edge[1],edge[2]});
        }
        PriorityQueue<int[]>pq= new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[]{k,0});
        int [] dist= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!pq.isEmpty()){
            int [] curr=pq.poll();
            int currNode=curr[0];
            int currDist=curr[1];
            if(currDist>dist[currNode]) {
                continue;
            }

            if(graph.containsKey(currNode)){
                for(int [] neibr:graph.get(currNode)){
                    int nextNode=neibr[0];
                    int nextDist=currDist+neibr[1];
                    if(nextDist<dist[nextNode]){
                        dist[nextNode]=nextDist;
                        pq.offer(new int[] {nextNode,nextDist});
                    }
                }
            }
        }

        int maxDist=Arrays.stream(dist).skip(1).max().getAsInt();
        return maxDist==Integer.MAX_VALUE ?-1:maxDist;
        
    }
}