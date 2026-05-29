class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for(int ele : bills){
            if(ele == 5) five++;
            else if(ele == 10){
                if(five > 0){
                    five--;
                    ten++;
                }else return false;
            }
            else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                    twenty++;
                }
                else if(five >= 3) {
                    twenty++;
                    five-=3;
                }else return false;
            }
        }
        return true;
    }
}