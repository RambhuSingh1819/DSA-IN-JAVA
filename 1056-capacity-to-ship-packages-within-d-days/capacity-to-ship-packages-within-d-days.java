class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;
        for(int ele : weights){
            low = Math.max(low, ele);
            high += ele;
        }
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(mid,weights,days)){
                ans = mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int mid ,int[] weights,int t){
        int k = 0;
        int sum = 0;
        for(int ele : weights){
            sum += ele;
            if(sum > mid){
                k++;
                sum = ele;
            }
        }
        if(sum > 0) k++;
        if(k > t) return false;
        return true; 
    }
}