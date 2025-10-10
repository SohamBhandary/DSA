class Solution {    
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1}; 
  
    private boolean isValid(int i, int j, int n, int m) {                               
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;        
        return true;
    }

    private void dfs(int row, int col, boolean[][] vis, char[][] mat, int n, int m) {                       
        vis[row][col] = true;        
        for (int i = 0; i < 4; i++) {          
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];           
            if (isValid(nRow, nCol, n, m) && mat[nRow][nCol] == 'O' && !vis[nRow][nCol]) {                
                dfs(nRow, nCol, vis, mat, n, m);
            }
        }
    }    
    
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];        
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && mat[0][j] == 'O') dfs(0, j, vis, mat, n, m);
            if (!vis[n - 1][j] && mat[n - 1][j] == 'O') dfs(n - 1, j, vis, mat, n, m);
        }        
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && mat[i][0] == 'O') dfs(i, 0, vis, mat, n, m);
            if (!vis[i][m - 1] && mat[i][m - 1] == 'O') dfs(i, m - 1, vis, mat, n, m);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O' && !vis[i][j]) mat[i][j] = 'X';
            }
        }
    }
}
