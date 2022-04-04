package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Date: 3/17/22
 * <p>
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * @author Maxim Balan
 **/
public class FourSum {

    public static void main(String[] args) {
        var i = new FourSum();
//        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{2, 2, 2, 2, 2}, 8));
    }

    public List<List<Integer>> solution(int[] nums, int target) {
        Arrays.sort(nums);
        var response = new ArrayList<List<Integer>>();
        var quad = new Stack<Integer>();

        System.out.println(Arrays.toString(nums));
        nSum(4, nums, response, quad, 0, target);
        return response;
    }

    public void nSum(int n, int[] nums, ArrayList<List<Integer>> response, Stack<Integer> quad, int start, int target) {
        if (n != 2) {
            for (int i = start; i < nums.length - n + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }

                quad.add(nums[i]);
                this.nSum(n - 1, nums, response, quad, i + 1, target - nums[i]);
                quad.pop();
            }
            return;
        }

        var l = start;
        var r = nums.length - 1;
        while (l < r) {
            if (nums[r] + nums[l] < target) {
                l++;
            } else if (nums[r] + nums[l] > target) {
                r--;
            } else {
                var list = new ArrayList<Integer>(quad);
                list.add(nums[l]);
                list.add(nums[r]);
                response.add(list);
                l++;
                while (nums[l] == nums[l - 1] && l < r) {
                    l++;
                }
            }
        }
    }
}
