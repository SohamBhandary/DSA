class Solution {
    private int [] delRow={-1,0,1,0};
    private int [] delCol={0,-1,0,1};
    private boolean isValid(int row,int col,int n,int m){
       if(row<0 || row>=n) return false;
       if(col<0 || col>=m) return false;
       return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n =heights.length;
        int m = heights[0].length;
        int [][] maxDiff= new int[n][m];
        for(int [] row : maxDiff ) Arrays.fill(row,(int)1e9);
        PriorityQueue<int []>pq= new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        maxDiff[0][0]=0;
        pq.add(new int []{0,0,0});
        while(!pq.isEmpty()){
            int [] it= pq.poll();
            int diff=it[0];
            int row=it[1];
            int col=it[2];
            if(row==n-1 && col==m-1) return diff;
            for(int i =0;i<4;i++){
                int newRow=row+delRow[i];
                int newCol=col+delCol[i];
                if(isValid(newRow,newCol,n,m)){
                    int currDiff=Math.abs(heights[newRow][newCol]-heights[row][col]);
                    int newEffort=Math.max(currDiff,diff);

                    if(newEffort<maxDiff[newRow][newCol]){
                        maxDiff[newRow][newCol]=newEffort;
                        pq.add(new int [] {newEffort,newRow,newCol});
                    }
                }
            }

        }

        return -1;
        

        
    }
}