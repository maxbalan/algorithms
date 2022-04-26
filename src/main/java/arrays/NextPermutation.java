package arrays;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * <p>
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * <p>
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * <p>
 * Given an array of integers nums, find the next permutation of nums.
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 **/
public class NextPermutation {

    public static void main(String[] args) {
        var i = new NextPermutation();
        var n = new int[]{1, 2, 3, 4, 2, 1};
        i.solution(n);
        System.out.printf("RESPONSE: %s%n", Arrays.toString(n));
    }

    public void solution(int[] nums) {
        //this will find the first descending element
        int left = nums.length - 2;
        while (left >= 0 && nums[left + 1] <= nums[left]) {
            left--;
        }

        if (left >= 0) {
            int peek = nums.length - 1;
            while (nums[peek] <= nums[left]) {
                peek--;
            }
            swap(left, peek, nums);
        }
        reverse(left + 1, nums);

    }

    private void reverse(int start, int[] nums) {
        int j = nums.length - 1;
        int i = start;
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }

    public void swap(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
