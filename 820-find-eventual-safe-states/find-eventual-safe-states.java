class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> list = new ArrayList<>();
        if(n == 0) return list;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < graph[i].length; j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            list.add(curr);

            for(Integer ele : adj.get(curr)){
                indegree[ele]--;

                if(indegree[ele] == 0){
                q.add(ele);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}