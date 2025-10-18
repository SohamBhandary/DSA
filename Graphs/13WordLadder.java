class Solution {
    static class Pair{
        String word;
        int steps;
        Pair(String word, int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> s = new HashSet<>(wordList);
        s.remove(beginWord);
        
        while(!q.isEmpty()){
            Pair current = q.poll();
            String word = current.word;
            int steps = current.steps;
            
            if(word.equals(endWord)){
                return steps;
            }
            
            for(int i = 0; i < word.length(); i++){
                char[] wordArray = word.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(s.contains(newWord)){
                        s.remove(newWord);
                        q.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
