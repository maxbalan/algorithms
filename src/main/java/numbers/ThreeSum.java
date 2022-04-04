package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 3/17/22
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 *
 * @author Maxim Balan
 **/
public class ThreeSum {

    public static void main(String[] args) {
        var i = new ThreeSum();
        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{0, 0, 0}));
        System.out.printf("RESPONSE: %s%n", i.solution(new int[]{0, 0, 0, 0}));
    }

    public List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        var res = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            var l = i + 1;
            var r = nums.length - 1;

            while (l < r) {
                var sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    var n = new ArrayList<Integer>();
                    n.add(nums[i]);
                    n.add(nums[l]);
                    n.add(nums[r]);
                    res.add(n);
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
