class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length ;
        int cnt = 0;
        if(n == 0) return cnt;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int end = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(intervals[i][1] <= end) {
                cnt++;
            }else end = intervals[i][1];
        }
        return n-cnt;
    }
}