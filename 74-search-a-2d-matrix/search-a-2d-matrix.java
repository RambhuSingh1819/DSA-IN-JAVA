class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       for(int i = 0; i < matrix.length;i++){
        int n = matrix[i].length;
        boolean r = Target (matrix[i],n,target);
        if(r) return true;
       }
        return false;
    }
    public boolean Target(int[] arr,int n , int target){
        int low = 0;
        int high = n -1 ;
        boolean b = false;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return !b;
            else if(target < arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return b;
    }
    
}