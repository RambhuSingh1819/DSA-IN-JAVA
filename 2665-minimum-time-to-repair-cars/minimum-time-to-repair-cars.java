class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long max = Integer.MIN_VALUE;
        for(int i : ranks) max = Math.max(max,i);
        long  high = max*cars*cars;
        long ans = high;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(isPossibel(ranks,cars,mid)){
                ans = mid;
                high = mid-1;
            }else low = mid + 1;
        }

        return ans;
    }
    public boolean isPossibel(int[] nums, int n, long mid){
        long total = 0;
        for(int ele : nums){
            total += Math.sqrt(mid/ele);
            if(total >= n) return true;
        }
        return false;
    }
}