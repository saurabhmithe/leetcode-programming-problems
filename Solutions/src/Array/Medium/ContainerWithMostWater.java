package Array.Medium;

public class ContainerWithMostWater {

    /*

    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    Find two lines, which together with x-axis forms a container,
    such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.

    Example:
    Input: [1,8,6,2,5,4,8,3,7]
    Output: 49

    */

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater container = new ContainerWithMostWater();
        int result = container.maxArea(height);
        System.out.println(result);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int area = 0;
        while (i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) j -= 1;
            else i += 1;
        }
        return area;
    }

}
