class Pair{
    String s;
    int level ;
    public Pair(String s , int level){
        this.s = s;
        this.level = level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord,
        List<String> wordList){

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(beginWord,1));

            Set<String> set = new HashSet<>();

            for(int i = 0; i < wordList.size(); i++){
                set.add(wordList.get(i));
            }

            set.remove(beginWord);
            
            while(!q.isEmpty()){
                Pair p = q.poll();
                String word = p.s;
                int lev = p.level;
                if(word.equals(endWord)) return lev;
                for(int i = 0; i < word.length(); i++){
                    for(char ch = 'a' ; ch <= 'z'; ch++){
                        char[] newString = word.toCharArray();
                        newString[i] = ch;
                        String newWord = new String(newString);
                        if(set.contains(newWord)){
                            set.remove(newWord);
                            q.add(new Pair(newWord,lev+1));
                        }
                        
                    }
                }

            }

        return 0;         
    }
}