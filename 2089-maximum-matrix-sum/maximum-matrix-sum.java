class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int minVal = 100001;
        long sum = 0;
        int negativeCnt = 0;

        for(int[] ele : matrix){
            for(int val : ele){
                sum += Math.abs(val);
                minVal = Math.min(minVal,Math.abs(val));
                if(val < 0) negativeCnt++;
            }
        }
        if(negativeCnt % 2 != 0) sum = sum - (2L*minVal);
        return sum;


        
    }
}