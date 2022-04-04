package numbers;

import java.util.Arrays;

/**
 * Date: 3/17/22
 * <p>
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 **/
public class ThreeSumClosest {

    public static void main(String[] args) {
        var i = new ThreeSumClosest();
        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{-1, 2, 1, -4}, 1));
        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{0, 0, 0}, 1));
        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{0, 0, 0, 0}, 1));
    }

    public int solution(int[] nums, int target) {
        Arrays.sort(nums);
        var res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            var l = i + 1;
            var r = nums.length - 1;

            while (l < r) {
                var sum = nums[i] + nums[l] + nums[r];

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }

                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
            }
        }

        return res;
    }
}
