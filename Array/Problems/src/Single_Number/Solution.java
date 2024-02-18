package Single_Number;
//LeetCode : 136. Single Number
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i : nums){
            num ^= i;
        }
        return num;
    }
}