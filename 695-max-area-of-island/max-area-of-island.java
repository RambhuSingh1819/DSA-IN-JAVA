class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    int total = dfs(i , j, grid, dir);
                    ans = Math.max(ans,total);
                }
            }
        }
        return ans;    
    }
    public int dfs(int row , int col, int[][] grid, int[][] dir){
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