package arrays;

import linkedlist.util.ListNode;

/**
 * Date: 3/17/22
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * <p>
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 **/
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        var i = new RemoveDuplicatesFromSortedArray();
        var l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        var l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        var l3 = new ListNode(2, new ListNode(6));
        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
//        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{2,2,2,2,2}, 8));
    }

    public int solution(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        var writeIndex = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[writeIndex] = nums[i + 1];
                writeIndex++;
            }
        }

        return writeIndex;
    }
}
