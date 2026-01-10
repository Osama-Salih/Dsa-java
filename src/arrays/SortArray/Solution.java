package arrays.SortArray;

public class Solution {
    public int[] sortArray(int []nums) {
        mergeSort(nums);
        return nums;
    }

    private void mergeSort(int []array) {
        int length = array.length;
        if (length <= 1) return;

        int mid = length / 2;
        int []leftArray = new int[mid];
        int []rightArray = new int[length - mid];

        int i = 0, j = 0;
        for (; i < length; i++) {
            if (i < mid) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }
    private void merge(int []leftArray, int []rightArray, int []array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
