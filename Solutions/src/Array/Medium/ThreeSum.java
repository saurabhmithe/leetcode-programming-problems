package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*

    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

    Note:
    The solution set must not contain duplicate triplets.

    Example:
    Given array nums = [-1, 0, 1, 2, -1, -4],
    [-4, -1, -1, 0, 1, 2]

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]

    */

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> results = threeSum.threeSum(a);
        for (List<Integer> list : results) {
            for (int i : list) System.out.print(i + "   ");
        }
        System.out.println();
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> threeSumList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int toFind = 0 - nums[i]; // taking compliment
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == toFind) {
                        threeSumList.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low += 1;
                        while (high > low && nums[high] == nums[high - 1]) high -= 1;
                        low += 1;
                        high -= 1;
                    } else if (nums[low] + nums[high] < toFind) low += 1;
                    else high -= 1;
                }
            }
        }
        return threeSumList;
    }

}
