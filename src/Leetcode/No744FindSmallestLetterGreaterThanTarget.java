package Leetcode;

/**
 * 744. Find Smallest Letter Greater Than Target
 *
 * Binary search.
 */
public class No744FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(final char[] letters, final char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }

        int start = 0, end = letters.length - 1;
        while (start < end) {
            final int mid = (start + end) / 2;
            if (letters[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return letters[start];
    }
}
