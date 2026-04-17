class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();

        // frequency map of t
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0;
        int count = 0; // matched chars
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while(r < s.length()){
            char ch = s.charAt(r);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) >= 0){
                    count++;
                }
            }

            // when all characters matched
            while(count == t.length()){
                
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    startIndex = l;
                }

                char leftChar = s.charAt(l);

                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar) + 1);
                    if(map.get(leftChar) > 0){
                        count--;
                    }
                }

                l++;
            }

            r++;
        }

        return minLen == Integer.MAX_VALUE 
                ? "" 
                : s.substring(startIndex, startIndex + minLen);
    }
}