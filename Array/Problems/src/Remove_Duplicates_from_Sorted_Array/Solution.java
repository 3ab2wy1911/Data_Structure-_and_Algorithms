package Remove_Duplicates_from_Sorted_Array;
// LeetCode Problem : 26. Remove Duplicates from Sorted Array

public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i =1; i< nums.length;i++){
            if (nums[count] != nums[i]){
                count++;
                nums[count] = nums[i];
            }
        }
        return ++count;
    }
}4
