package MergeSort;
// O(n) SC & O(n Log n) TC
public class MergeSort {
    public static void sort(int[] nums, int left, int right) {
        if(left < right){
            int mid = left + (right - left) / 2;
            sort(nums,left,mid);
            sort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    static void merge(int[] nums, int left, int mid, int right) {
        int [] leftArr = new int[mid - left + 2];
        int [] rightArr = new int[right - left + 1];
        if (mid - left + 1 >= 0) System.arraycopy(nums, left, leftArr, 0, mid - left + 1);
        for (int i = 0 ; i< right - mid ;i++){
            rightArr[i] = nums[mid + 1 + i];
        }
        leftArr[mid-left+1]= Integer.MAX_VALUE;
        rightArr[right-mid]= Integer.MAX_VALUE;
        int p1 =0, p2 = 0;
        for (int i = left ; i<= right ; i++){
            if(leftArr[p1] < rightArr[p2]){
                nums[i] = leftArr[p1++];
            }
            else{
                nums[i] = rightArr[p2++];
            }
        }
    }
}