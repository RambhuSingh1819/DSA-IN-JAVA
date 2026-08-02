class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < n+1; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it : times){
            adj.get(it[0]).add(new int[]{it[1], it[2]});
        }

        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,k});

        while(!pq.isEmpty()){

            int[] temp = pq.poll();
            int tm = temp[0];
            int u = temp[1];

            for(int[] it : adj.get(u)){
                int v = it[0];
                int ctm = it[1];

                if(ans[v] > tm + ctm){
                    ans[v] = tm + ctm;
                    pq.add(new int[]{ans[v],v});
                }
            }

        }
        int maxi = -1;
        for(int i = 1; i <= n; i++){
            if(ans[i] == Integer.MAX_VALUE) return -1;
            maxi = Math.max(maxi,ans[i]);
        }
        return  maxi;
    }
}