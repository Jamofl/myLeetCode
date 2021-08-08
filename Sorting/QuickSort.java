package Sorting;

public class QuickSort {

    private int[] swap(int[] nums, int i, int j){
        if (i == j)
            return nums;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public void quickSort(int[] nums, int start, int end){
        if (end <= start)
            return;
        int pivot = nums[start];

        int i = start + 1;
        int j = end;
        while (i <= j){
            if (nums[i] < pivot)
                i ++;
            else if(nums[j] > pivot)
                j --;
            else{
                swap(nums, i, j);
                i ++;
                j --;
            }
        }
        swap(nums, start, j); // swap pivot and element at j
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    public static void main(String[] args){
//        QuickSort q = new QuickSort();
//        int[] nums = new int[]{5,1,1,2,0,0};
//        q.quickSort(nums, 0 , nums.length - 1);
    }
}
