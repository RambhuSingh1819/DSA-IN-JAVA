class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        List<List<String>> ans = new ArrayList<>();

        if (!dict.contains(endWord))
            return ans;

        // Stores shortest distance from beginWord
        Map<String, Integer> level = new HashMap<>();

        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        level.put(beginWord, 0);

        while (!q.isEmpty()) {

            String word = q.poll();

            int steps = level.get(word);

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;

                    String newWord = new String(arr);

                    if (dict.contains(newWord) && !level.containsKey(newWord)) {

                        level.put(newWord, steps + 1);

                        q.offer(newWord);
                    }
                }

                arr[i] = original;
            }
        }

        if (!level.containsKey(endWord))
            return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, level, path, ans);

        return ans;
    }

    private void dfs(String word,
                     String beginWord,
                     Map<String, Integer> level,
                     List<String> path,
                     List<List<String>> ans) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);

            ans.add(temp);

            return;
        }

        int currLevel = level.get(word);

        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {

            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {

                arr[i] = ch;

                String prev = new String(arr);

                if (level.containsKey(prev) &&
                    level.get(prev) == currLevel - 1) {

                    path.add(prev);

                    dfs(prev, beginWord, level, path, ans);

                    path.remove(path.size() - 1);
                }
            }

            arr[i] = original;
        }
    }
}