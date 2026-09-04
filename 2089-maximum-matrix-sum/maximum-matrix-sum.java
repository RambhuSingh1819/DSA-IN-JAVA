class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int minVal = 100001;
        long sum = 0;
        int negativeCnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int val = matrix[i][j];
                sum += Math.abs(val);
                minVal = Math.min(minVal,Math.abs(val));
                if(val < 0) negativeCnt++;
            }
        }
        if(negativeCnt % 2 != 0) sum = sum - (2L*minVal);
        return sum;


        
    }
}