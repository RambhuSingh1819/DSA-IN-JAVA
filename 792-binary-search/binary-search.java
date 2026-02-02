class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length-1;
        int ans =Bs(nums,0,n,target);
        return ans;
    }
    public int Bs(int[] arr,int low, int high, int target){
        if(low > high) return -1;
        int mid = low + (high - low)/2;
        if(arr[mid] == target) return mid;
        if(arr[mid] > target) return Bs(arr, low, mid-1, target);
        if(arr[mid] < target) return Bs(arr, mid+1 , high, target);
        return -1;
    }
}