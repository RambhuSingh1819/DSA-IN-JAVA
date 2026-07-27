class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];  

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int j = 0; j < n ; j++){
            if(board[0][j] == 'O' && vis[0][j] == 0) dfs(0,j,board,vis,dir);
            if(board[m-1][j] == 'O' && vis[m-1][j] == 0) dfs(m-1,j, board,vis,dir);
        }
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O' && vis[i][0] == 0) dfs(i, 0, board, vis,dir);
            if(board[i][n-1] == 'O' && vis[i][n-1] == 0) dfs(i,n-1,board, vis,dir);
        }
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return ;
    }
    public void dfs(int i , int j , char[][] board, int[][] vis,int[][]dir){
        int m = board.length;
        int n = board[0].length;
        vis[i][j] = 1;
        for(int[] dxy : dir){
            int nr =i + dxy[0];
            int nc =j + dxy[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O' && vis[nr][nc] == 0){
                dfs(nr,nc,board,vis,dir);
            }
        }
    }
}