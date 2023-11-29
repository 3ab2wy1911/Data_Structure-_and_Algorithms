package Three_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode : 15. 3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i =0; i<n-2;i++){

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = n - 1;
            int s = i + 1;

            while (s < j ){

                if (nums[s]+nums[j] == (-nums[i])){
                    list.add(new ArrayList<>(List.of(nums[i],nums[s],nums[j])));
                    while (s < j && nums[s] == nums[s + 1])  s++;
                    while (s < j && nums[j] == nums[j - 1])  j--;
                    s++;
                    j--;
                }

                else if(nums[s]+nums[j] < (-nums[i])){
                    s++;
                }

                else {
                    j--;
                }
            }
        }

        return list;
    }
}