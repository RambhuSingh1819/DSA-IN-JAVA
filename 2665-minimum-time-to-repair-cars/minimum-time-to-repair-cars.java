class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long max = Long.MAX_VALUE;
        for(int ele : ranks) max= Math.min(max,ele);
        long high = max *(long) cars * cars;
        long ans = high;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(isPossible(ranks,mid,cars)){
                ans = mid;
                high = mid -1;
            }else low = mid + 1;
        }
        return ans;
    }
    public boolean isPossible(int[] ranks,long mid, int k){
        long num = 0;
        for(int it : ranks){
            //n = sqrt(mid/r)
            num +=(long) Math.sqrt(mid/it);
            if(num >= k) return true;
        }
        return false;   
    }
}