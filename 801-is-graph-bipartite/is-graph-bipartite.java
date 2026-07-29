class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] visit = new int[n];

        Arrays.fill(visit,-1);

        for(int i = 0; i < n; i++){
            if(visit[i] == -1){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visit[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int ele : graph[curr]){
                        if(visit[ele] == -1){
                            visit[ele] = 1 - visit[curr];
                            q.add(ele);
                        }
                        else if(visit[ele] == visit[curr]) return false;
                    }
                }
            }
        }
        return true;
        
    }
}