package BubbleSort;
// O(1) SC & O(N^2)TC
public class BubbleSort {
    public static void sort(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            boolean flag = true;
            for(int j =0;j<len-1;j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
