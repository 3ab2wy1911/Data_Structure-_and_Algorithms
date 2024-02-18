package Contains_Duplicate;

import java.util.HashSet;

//LeetCode : 217. Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> n = new HashSet<>();
        for(int i : nums){
            if(n.contains(i))   return true;
            n.add(i);
        }
        return false;
    }
}
