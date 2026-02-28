class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;
        for(int ele : quantities) high = Math.max(ele,high);
        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(n,quantities,mid)){
                ans = mid;
                high = mid-1;
            }else low = mid + 1;
        }
        return ans;
    }
    public boolean isPossible(int n , int[] nums, int mid){
        int sum = 0;
        for(int i : nums){
            sum += (i+mid-1)/mid;
        }
        return sum <= n;
    }
}