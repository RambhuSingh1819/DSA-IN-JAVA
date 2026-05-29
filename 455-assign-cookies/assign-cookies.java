class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        if(n<= 0 || m <= 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0, cokies = 0;
        while(cokies < m && child < n){
            if(g[child] <= s[cokies]) child++;
            cokies++;
        }
        return child;
    }
}