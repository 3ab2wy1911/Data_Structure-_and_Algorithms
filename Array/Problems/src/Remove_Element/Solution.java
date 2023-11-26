package Remove_Element;
//LeetCode : 27. Remove Element
public class Solution {
    public int removeElement(int[] nums, int val) {
        // 2 pointers and then swap every time you don't find the value.
        int count =0 ;
        for (int i=0; i<nums.length;i++){
            if(nums[i] != val)
            {
                int temp = nums[count];
                nums[count] = nums[i];
                nums [i] = nums[count];
                count++;
            }
        }
        return count;
    }
}
