package Three_Sum_Closest;

import java.util.Arrays;

// LeetCode : 16. 3Sum Closest.
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int ans = target;

        for(int k =0; k<nums.length;k++){

            int i = k+1, j = nums.length-1;

            while (i<j){
                int sum = nums[i] + nums[k] + nums[j];
                int c1 = Math.abs(target-ans);
                int c2 = Math.abs(target-sum);

                if (sum == target){
                    return sum;
                }

                if ( target > sum){
                    if(ans == target){
                        ans = sum;
                    }
                    else if (c1 > c2){
                        ans = sum;
                    }
                    i++;
                }

                else {
                    if(ans == target){
                        ans = sum;
                    }
                    else if (c1 > c2){
                        ans = sum;
                    }
                    j--;
                }
            }
        }
        return ans;
    }
}
