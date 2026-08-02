class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        pq.add(new int[]{0,0,0});

        int[][] dis =new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) dis[i][j] = Integer.MAX_VALUE;
        }      
        dis[0][0] = 0;

        int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int wt  = temp[0];
            int row = temp[1];
            int col = temp[2];
            if(row == n-1 && col == m-1) return wt;
           
                for(int[] it : dir){
                    
                    int nr = row + it[0];
                    int nc = col + it[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                       
                        int diff = Math.abs((heights[row][col])-(heights[nr][nc]));
                        int maxEffort = Math.max(wt,diff);               
                        if(maxEffort < dis[nr][nc])  {
                            dis[nr][nc] = maxEffort;
                            pq.add(new int[]{maxEffort,nr,nc});
                        }
                    }
                }
        }
        return 0;       
    }
}