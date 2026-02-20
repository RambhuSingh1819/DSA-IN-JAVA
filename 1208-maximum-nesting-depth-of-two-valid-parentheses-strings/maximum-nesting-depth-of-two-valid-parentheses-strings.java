class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        int cnt = 0;
        for(int i = 0; i < seq.length(); i++){
            if(seq.charAt(i) == '('){
                cnt++;
                arr[i] = cnt%2;
            }else {
                arr[i] = cnt%2;
                cnt--;
            }
        }
        return arr;
    }
}