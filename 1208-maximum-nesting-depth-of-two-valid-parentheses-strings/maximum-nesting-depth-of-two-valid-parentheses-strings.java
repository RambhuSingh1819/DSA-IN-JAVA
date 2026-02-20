class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] arr = new int[seq.length()];
        int cnt = 0;
        // for(int i = 0; i < seq.length(); i++){
        //     if(seq.charAt(i) == '('){
        //         cnt++;
        //         arr[i] = cnt%2;
        //     }else {
        //         arr[i] = cnt%2;
        //         cnt--;
        //     }
        // }
        for (int i = 0, x = 0; i < n; ++i) {
            if (seq.charAt(i) == '(') {
                arr[i] = x++ & 1;
            } else {
                arr[i] = --x & 1;
            }
        }
        return arr;
    }
}