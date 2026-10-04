class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            high = Math.max(high,piles[i]);
        }
        int ans = -1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(isPossible(piles,mid,h)){
                high = mid;
            }else low = mid + 1;
        }
        return low;  
    }
    public boolean isPossible(int nums[],int mid , int k){
        int hrs = 0;
        for(int ele : nums){
            hrs += (ele + mid -1)/mid;
        }
        if(hrs > k) return false;
        else return true;
    }
}