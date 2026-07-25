class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjEle = new ArrayList<>();
        for(int i= 0; i < numCourses; i++){
            adjEle.add(new ArrayList<>());
        }
        for(int[] edg : prerequisites){
            int U = edg[0];
            int V = edg[1];

            adjEle.get(V).add(U);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] pathVisit = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visit[i]){
                if(dfs(i,pathVisit,visit,adjEle)) return false;
            } 

        }
        return true;
    }
    public boolean dfs(int node, boolean[] pathVisit, boolean[] visit, List<List<Integer>> adjEle){
        visit[node] = true;
        pathVisit[node] = true;

        for(Integer to : adjEle.get(node)){
            if(!visit[to]) {
               if(dfs(to,pathVisit,visit,adjEle)) return true;
            }
            else if(pathVisit[to]) return true;
        }
        pathVisit[node] = false;
        return false;
    }
    
}