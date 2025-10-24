class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left=grid[0][0];
        int right= n*n-1 ;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canSwim(grid,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
        
    }
    private boolean canSwim(int grid[][],int t){
        int n= grid.length;
        boolean [][] visi= new boolean[n][n];
        return dfs(grid,visi,0,0,t);
    }
    private boolean dfs(int grid[][],boolean visi[][],int i, int j ,int t){
        int n= grid.length;
        if(i<0 ||i>=n || j<0 || j>=n || visi[i][j] || grid[i][j]>t ){
            return false;
        }
        if(i==n-1 && j==n-1){
            return true;
        }
        visi[i][j]=true;
        return dfs(grid,visi,i+1,j,t) || dfs (grid,visi,i-1,j,t) || dfs (grid,visi,i,j+1,t) ||
        dfs (grid,visi,i,j-1,t);
    }
}