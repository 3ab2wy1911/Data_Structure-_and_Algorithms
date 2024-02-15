package QuickSort;
// O(1) SC & O(nLogN) TC
public class QuickSort {
    public static void sort(int [] nums, int start, int end){
        if(start < end){
            int pivot = partition(nums, start, end);
            sort(nums, start, pivot-1);
            sort(nums,pivot+1, end);
        }
    }

    static int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int i = start;
        for(int j = start; j < end; j++){
            if(nums[j] <= pivot){
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[end];
        nums[end] = tmp;
        return i;
    }

}
