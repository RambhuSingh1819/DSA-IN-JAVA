class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n+1];
        int[] arr = new int[n];
        for(int[] row : bookings){
            int fst = row[0]-1;
            int sec = row[1];
            int cost = row[2];
            ans[fst] += cost;
            ans[sec] -= cost;

        }        
        arr[0] = ans[0];
        for(int i = 1; i < n; i++){
            arr[i] = arr[i-1] + ans[i];
        }
        return arr;
    }
}