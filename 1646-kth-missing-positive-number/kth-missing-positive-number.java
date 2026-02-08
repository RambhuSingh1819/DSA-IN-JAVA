class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0; 
        int n = arr.length;
        int high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            int missingNumber = arr[mid] - (mid + 1);
            if(missingNumber < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
}