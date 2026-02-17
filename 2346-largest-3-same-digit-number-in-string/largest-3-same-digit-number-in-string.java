class Solution {
    public String largestGoodInteger(String num) {
        // String max = "";

        // for (int i = 0; i <= num.length() - 3; i++) {
        //     char c = num.charAt(i);

        //     if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
        //         String candidate = num.substring(i, i + 3);
        //         if (max.compareTo(candidate) < 0) {
        //             max = candidate;
        //         }
        //     }
        // }
        // return max;


        String [] arr={"999","888","777","666","555","444","333","222","111","000"};

         for(int i = 0 ; i<arr.length ; i++){
            if(num.indexOf(arr[i]) != -1){
                return arr[i];
            }
         }
         return "";
    }
}
