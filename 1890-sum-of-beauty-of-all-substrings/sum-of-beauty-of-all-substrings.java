class Solution {
    public int beautySum(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j <s.length(); j++){
                String  str = s.substring(i,j+1);
                cnt += findFreq(str);
            }   
        }
        return cnt;
    }
    public int findFreq(String s){
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
       for(int i = 0; i < 26; i++){
        if(arr[i] > 0){
            maxi = Math.max(arr[i],maxi);
            mini = Math.min(arr[i],mini);
        }
       }
       return maxi-mini;

    }
}