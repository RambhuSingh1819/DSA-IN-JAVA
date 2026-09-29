class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == ')' || grid[n - 1][m - 1] == '(') {
            return false;
        }
        Boolean[][][] b = new Boolean[n][m][n + m];
        return solve(0,0,grid,0,b);
        
    }
    public boolean solve(int i, int j, char[][] grid, int r,Boolean[][][] b){
        int n = grid.length;
        int m = grid[0].length;
        if(i >= n || j >= m) return false;
        char ch = grid[i][j];
        r = (ch=='(') ? r + 1 : r - 1 ;
        if(r < 0) return false;
        
        if(i == n-1 && j == m-1) return r == 0;
        if(b[i][j][r] != null) return b[i][j][r];
        boolean down =  solve(i+1,j,grid,r,b);
        boolean right = solve(i,j+1,grid,r,b);
        return b[i][j][r] = (down || right);
    }
}