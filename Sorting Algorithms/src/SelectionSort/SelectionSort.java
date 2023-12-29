package SelectionSort;
// O(1)SC & O(N^2)TC
public class SelectionSort {
    public static void sort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n-1; i++){
            int minIndex = i;
            for(int j = i+1;j<n;j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }
    }
}
