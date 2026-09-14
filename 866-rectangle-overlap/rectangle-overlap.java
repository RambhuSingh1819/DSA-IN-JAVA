class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //CASES WHEN TWO TRIANGLE ARE NEVER OVERLAP
        if(
            //case 1: R1[X2] <= R2[X1]
            rec1[2] <= rec2[0] || 
            
            //case 2: R1[Y2] <= R2[Y1]
            rec1[3] <= rec2[1] || 
            
            //case 3: R1[X1] >= R2[X1]
            rec1[0] >= rec2[2] || 
            
            //case 4: R1[Y1] >= R2[Y2]
            rec1[1] >= rec2[3])
        return false;
    return true;      
    }
}