class Solution {
    int totalTime = 0;
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int totalFreshOrange = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j,0});
                if(grid[i][j] == 1) totalFreshOrange++;
            }
        }
        if(totalFreshOrange == 0) return 0;
        if(q.isEmpty()) return -1;
        int totalNoRoten = 0;
        while(!q.isEmpty()){
            int len = q.size();
            int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
            for(int i = 0; i < len; i++){
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                int time = curr[2];
                for(int[] dr : dir){
                    int nr = row + dr[0];
                    int nc = col + dr[1];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                        q.add(new int[]{nr,nc,time+1});
                        grid[nr][nc] = 2;
                        totalNoRoten++;
                        totalTime = Math.max(time+1,totalTime);
                        if(totalFreshOrange == totalNoRoten) return totalTime;
                    }
                }
            }
        }
        return  -1;     
    }
}