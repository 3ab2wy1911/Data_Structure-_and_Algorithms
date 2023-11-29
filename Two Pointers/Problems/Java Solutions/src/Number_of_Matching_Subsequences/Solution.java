package Number_of_Matching_Subsequences;

import java.util.HashMap;

//792. Number of Matching Subsequences
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (var word : map.keySet()){
            int i = 0, j =0 ;
            while (i < s.length() && j < word.length()){
                if (s.charAt(i) == word.charAt(j)){
                    ++j;
                }
                ++i;
            }
            if (j == word.length()) count+=map.get(word);
        }
        return count;
    }
}

