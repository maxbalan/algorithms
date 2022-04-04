package numbers;

/**
 * Date: 3/17/22
 *
 * @author Maxim Balan
 **/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        var i = new ContainerWithMostWater();
        System.out.printf("RESPONSE: %d%n", i.solution(new int[]{1, 2, 3, 4}));
    }

    public int solution(int[] height) {
        var i = 0;
        var n = height.length - 1;
        var maxArea = 0;

        while (i < n) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[n]) * (n - i));

            if (height[i] > height[n]) {
                n--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}
