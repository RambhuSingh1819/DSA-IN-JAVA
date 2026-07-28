class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        for(int i = 0; i < m ; i++){

            if(grid[i][0] != 0){int t =  dfs(i, 0, grid, dir);}

            if(grid[i][n-1] != 0) {int t2 = dfs(i,n-1, grid, dir);}

        }

        for(int j = 0; j < n ; j++){

            if(grid[0][j] != 0){int t3 =  dfs(0, j, grid, dir);
}
            if(grid[m-1][j] != 0){int t4 =  dfs(m-1,j, grid, dir);}

        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    int maxi = dfs(i,j,grid,dir);
                    ans += maxi;
                }
            }
        }
        return ans;
    }
    public int dfs(int row, int col, int[][] grid, int[][] dir){
        int m = grid.length;
        int n = grid[0].length;

        int total = grid[row][col];

        grid[row][col] = 0;

        for(int[] xy : dir){
            int nr = row + xy[0];
            int nc = col + xy[1];
            
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 0){
                total += dfs(nr, nc, grid, dir);
            }
        }
        return total;
    }
}