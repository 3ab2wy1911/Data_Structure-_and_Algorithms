package InsertionSort;
// O(1)SC & O(N^2)TC
public class InsertionSort {
    public static void sort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int curr = nums[i];
            int j = i;
            while(j>0 && nums[j-1]>curr){
                nums[j] = nums[j-1];
                --j;
            }
            nums[j] = curr;
        }
    }
}
