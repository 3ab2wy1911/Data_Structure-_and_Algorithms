import BubbleSort.BubbleSort;
import InsertionSort.InsertionSort;
import MergeSort.MergeSort;
import QuickSort.QuickSort;
import SelectionSort.SelectionSort;

public class Main {

    public static void print(int[] nums){
        int n = nums.length;
        System.out.print('{');
        for (int i =0; i<n-1;i++) {
            System.out.print(nums[i]+ ", ");
        }
        System.out.print(nums[n-1]+"}");
    }
    public static void main(String[] args) {
        int[] nums = {9,4,3,7,6,1,2,5,8};
//        BubbleSort.sort(nums);  // Bubble Sort
//        SelectionSort.sort(nums); // Selection Sort
//        InsertionSort.sort(nums); // Insertion Sort
//        QuickSort.sort(nums,0,nums.length-1); // Quick Sort
        MergeSort.sort(nums,0,nums.length-1); // Merge Sort
        print(nums);
    }
}