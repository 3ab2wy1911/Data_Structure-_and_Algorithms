package Find_Words_Containing_Character;

//2942. Find Words Containing Character

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List <Integer> list = new ArrayList<>();
        int i = 0;
        for (String word : words){
            if (word.indexOf(x) > -1){
                list.add(i);
            }
            i++;
        }
        return list;
    }
}
