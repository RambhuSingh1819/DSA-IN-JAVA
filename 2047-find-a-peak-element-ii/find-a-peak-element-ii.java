class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0 , high = m-1;
        while(low <= high){
            int mid = low + (high - low );
                int maxRow = findMaxElement(mat,n,m,mid);
                int left = mid - 1 >= 0 ? mat[maxRow][mid - 1]:-1;
                int right = mid + 1 < m ? mat[maxRow][mid + 1]:-1;
                if(mat[maxRow][mid] > left && mat[maxRow][mid] > right) return new int[]{maxRow,mid};
                else if(mat[maxRow][mid] < left) high = mid -1;
                else low = mid + 1;
            }
    return new int[]{-1,-1};
    }
    public int findMaxElement(int[][] arr,int n , int m , int mid){
        int maxValue = -1;
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(arr[i][mid] > maxValue){
                maxValue = arr[i][mid];
                idx = i;
            }
        }
        return idx;
    }
}