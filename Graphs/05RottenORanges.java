class Solution {

    private int[] delRow={-1,0,1,0};
    private int []delCol={0,1,0,-1};
    private boolean isValid(int i , int j ,int n , int m){
           if(i < 0 || i >= n) return false;
        if(j < 0 || j >= m) return false;
        return true;

    }
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int time=0;
        int count=0;
        int total=0;
        Queue<int[]>q= new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] !=0){
                    total++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            count=count+size;
            while(size-- >0){
            int []cell=q.poll();
            int row=cell[0];
            int col=cell[1];
            for(int i=0;i<4;i++){
                int newRow=row+delRow[i];
                int newCol=col+delCol[i];
                if(isValid(newRow,newCol,n,m) && grid[newRow][newCol]==1){
                    grid[newRow][newCol]=2;
                    q.add(new int [] {newRow,newCol});
                }
            }
              

        }
        if(!q.isEmpty()) time++;      
   
    }
    if(total==count) return time;

    return -1;
}

}