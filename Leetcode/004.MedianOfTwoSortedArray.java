package Leetcode;
/**
 * @author xiangfeidong
 *
 * 4.Median of Two Sorted Arrays
 *  This can be converted to find kth number in new array.
 *
 *  If we want to find kth number, we can compare (k/2)th number in each array.
 *  In the array with smaller (k/2)th number, its left part must not contain the wanted kth number.
 *  So we can update k and find it in a smaller range.
 *  Note: take k as 1-based index.
 *
 *  Time: O(log(m+n))  m and n are lengths of two arrays.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int newLen = A.length + B.length;
        if (newLen % 2 == 0) {  //New array length is even.
            return (findKth(newLen / 2, A, 0, B, 0) + findKth(newLen / 2 + 1, A, 0, B, 0)) / 2.0;
        } else {    //New array length is odd.
            return findKth(newLen / 2 + 1, A, 0, B, 0);
        }
    }

    private int findKth(int k, int[] A, int startOfA, int[] B, int startOfB) {
        if (startOfA >= A.length) { //A's index exceeds bound
            return B[startOfB + k - 1];
        }
        if (startOfB >= B.length) { //B's index exceeds bound
            return A[startOfA + k - 1];
        }
        if (k == 1) {   //Exit condition. No need for recursion call.
            return Math.min(A[startOfA], B[startOfB]);
        }

        //(k/2)th numbers in A and B. If it exceed the bound, set key to max_int to avoid updating start.
        int keyOfA = startOfA + k / 2 - 1 >= A.length ? Integer.MAX_VALUE : A[startOfA + k / 2 - 1];
        int keyOfB = startOfB + k / 2 - 1 >= B.length ? Integer.MAX_VALUE : B[startOfB + k / 2 - 1];

        if (keyOfA > keyOfB) {  //B's left must not contain desired number. Update k and startOfB.
            return findKth(k - k / 2, A, startOfA, B, startOfB + k / 2);
        } else {    //A's left must not contain desired number. Update k and startOfA.
            return findKth(k - k / 2, A, startOfA + k / 2, B, startOfB);
        }
    }
}
