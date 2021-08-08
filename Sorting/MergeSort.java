package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeSort {
    int[] temp;

    private int[] sort(int[] nums){
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end){
        if (end == start)
            return;
        int middle = start + (end - start) / 2;

        mergeSort(nums, start, middle); // sort left
        mergeSort(nums, middle + 1, end); // sort right

        // merge sorted left part and right part
        int i = start;
        int j = middle + 1;
        int index = start;
        while(i <= middle && j <= end){
            if (nums[i] < nums[j]){
                temp[index ++] = nums[i ++];
            }
            else {
                temp[index ++] = nums[j ++];
            }
        }
        while(i <= middle)
            temp[index ++] = nums[i ++];
        while(j <= end)
            temp[index ++] = nums[j ++];

        // in place merge sort
        for(int k = start; k <= end; k ++)
            nums[k] = temp[k];
    }

    public static void main(String[] args){
        MergeSort m = new MergeSort();
        int[] re = m.sort(new int[]{5,3,4,2,1,6});
        System.out.println(Arrays.toString(re));
    }
}
