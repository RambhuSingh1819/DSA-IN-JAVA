class Solution {
    public int findChampion(int n, int[][] edges) {

        int[] inOrder = new int[n];
        for(int[] it : edges){
            int u = it[0];
            int v = it[1];
            inOrder[v]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(inOrder[i] == 0) list.add(i);
        }
        if(list.size() == 1) return list.get(0);
        else return -1;
    }
}