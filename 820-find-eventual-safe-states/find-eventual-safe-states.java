class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int ele : graph[i]){
                adj.get(ele).add(i);
            }
        }
        int inOrder[] = new int[n];
        for(int i = 0; i < n; i++){
            for(int ele : adj.get(i)){
                inOrder[ele]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inOrder[i] == 0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int ele : adj.get(curr)){
                inOrder[ele]--;
                if(inOrder[ele] == 0){
                    q.add(ele);
                }
            }   
        }
        Collections.sort(ans);
        return ans;
    }
}