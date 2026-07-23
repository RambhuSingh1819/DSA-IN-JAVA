class Solution {
    public int findCircleNum(int[][] isConnected) {

        int m = isConnected.length;
        int n = isConnected[0].length;

        List<List<Integer>> adjLs = new ArrayList<>();

        for(int i = 0; i < n; i++) adjLs.add(new ArrayList<>());

        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int cnt = 0;
        int[] visited = new int[n+1];
        Arrays.fill(visited,0);

        for(int i = 0; i < m; i++){
            if(visited[i] == 0) {
                cnt++;
                dfs(i,adjLs,visited);
            }
        }
        return cnt;  
    }
    public void dfs(int node, List<List<Integer>> adjLs ,int[] visited){
        visited[node] = 1;
        for(Integer it : adjLs.get(node)){
            if(visited[it] == 0)  dfs(it,adjLs,visited);
        }    
    }
}