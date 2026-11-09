/*class Solution {
    private int[] ans;
    private int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ans = new int[numCourses];
        index = numCourses - 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); 
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) { 
                if (dfs(i, vis, pathVis, adj)==true) {
                    return new int[0];
                }
            }
        }
        
        return ans;
    }
    private boolean dfs(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, vis, pathVis, adj)==true) {
                    return true;
                }
            } else if ((pathVis[neighbor])==true) {
                return true; 
            }
        }

        pathVis[node] = false; 
        ans[index] = node;
        index--;
        
        return false; 
    }
}*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        int[] ans = new int[n];
        int index = 0;

        int[] indegree = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            ans[index++] = curr;

            for (Integer ele : adj.get(curr)) {
                indegree[ele]--;

                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }

        if (index != n) return new int[0];

        return ans;
    }
}