package arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 **/
public class MedianSortedArrays {

    public static void main(String[] args) {
        var i = new MedianSortedArrays();
        var n1 = new int[]{1, 2};
        var n2 = new int[]{3};
        System.out.printf("RESPONSE: %s%n", i.solution(n1, n2));
    }

    public double solution(int[] nums1, int[] nums2) {
        var a = nums1;
        var b = nums2;
        if (a.length > b.length) {
            a = nums2;
            b = nums1;
        }

        var left = 0;
        var right = a.length - 1;
        var total = a.length + b.length;
        var half = total / 2;

        while (true) {
            var i = (left + right) < 0 ? (left + right) : (left + right) / 2;
            var j = half - i - 2;

            var aL = i >= 0 ? a[i] : Float.NEGATIVE_INFINITY;
            var aR = (i + 1) < a.length ? a[i + 1] : Float.POSITIVE_INFINITY;

            var bL = j >= 0 ? b[j] : Float.NEGATIVE_INFINITY;
            var bR = (j + 1) < b.length ? b[j + 1] : Float.POSITIVE_INFINITY;

            if (bL <= aR && aL <= bR) {
                //odd
                if (total % 2 != 0) {
                    return Math.min(aR, bR);
                } else {
                    return (Math.max(aL, bL) + Math.min(aR, bR)) / 2.0;
                }
            } else if (aL > bR) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
    }

}
