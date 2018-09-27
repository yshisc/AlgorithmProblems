package Leetcode;
/**
 * @author xiangfeidong
 *
 * 88.Merge Sorted Array
 *
 * We process the two arrays from right to left.
 * Keep a pointer for each array, find a greater number, put it into right position, and decrement that pointer.
 * Stop when any pointer becomes negative, now add left numbers in second array if we have not finished its traversal.
 */
public class No088MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[i + j + 1] = nums1[i--];
            } else {
                nums1[i + j + 1] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j--];
        }
    }
}
