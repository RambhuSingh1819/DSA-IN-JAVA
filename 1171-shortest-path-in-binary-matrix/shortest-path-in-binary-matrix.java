class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        boolean[][] visit = new boolean[n][n];

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,1});
        visit[0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int wt = curr[2];

            if(row == n-1 && col == n-1) return wt;

            for(int dr = -1; dr <= 1; dr++){
                for(int dc = -1; dc <= 1; dc++){

                    if(dr == 0 && dc == 0) continue;

                    int nr = row + dr;
                    int nc = col + dc;
                    
                    if(nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 0 &&
                        !visit[nr][nc]){

                            visit[nr][nc] = true;
                            q.offer(new int[]{nr,nc,wt+1});
                    }
                }
            }
        }
    return -1;
    }
}


