package Append_Characters_to_String_to_Make_Subsequence;
//LeetCode : 2486. Append Characters to String to Make Subsequence
class Solution {
    public int appendCharacters(String t, String s) {
        int i = 0, j =0 ;
        while (i < t.length() && j < s.length()){
            if (t.charAt(i) == s.charAt(j)){
                ++j;
            }
            ++i;
        }
        return s.length() - j;
    }
}