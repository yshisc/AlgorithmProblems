package Leetcode;

/**
 * 278. First Bad Version
 *
 * Binary Search. Find first version that isBadVersion(version) = true.
 */
public class No278FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 0, end = n;
        while (start < end) {
            final int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /**
     * Fake API.
     */
    private boolean isBadVersion(int mid) {
        return false;
    }
}
