class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;
        int originalColor = grid[row][col];
        boolean[][] vis = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        List<int[]> borderCells = new ArrayList<>();
        
        q.add(new int[]{row, col});
        vis[row][col] = true;
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            
            boolean isBorder = false;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // If neighbor is out of bounds or of a different original color, 
                // then current cell (r, c) is on the border.
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    isBorder = true;
                } else if (grid[nr][nc] != originalColor) {
                    isBorder = true;
                } else if (!vis[nr][nc] && grid[nr][nc] == originalColor) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
            
            // If it's part of the border, record it
            if (isBorder) {
                borderCells.add(new int[]{r, c});
            }
        }
        
        // Color all collected border cells
        for (int[] cell : borderCells) {
            grid[cell[0]][cell[1]] = color;
        }
        
        return grid;
    }
}