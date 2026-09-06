class Solution {
    public String toLowerCase(String s) {
       // return s.toLowerCase(); 
       char[] chr = s.toCharArray();
       for(int i = 0; i < chr.length; i++){
            if(chr[i] >='A' && chr[i] <='Z'){
                chr[i] = (char)(chr[i]+32);
            }
       }  
       return new String(chr);
    }
}