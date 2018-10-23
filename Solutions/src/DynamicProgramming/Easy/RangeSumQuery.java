package DynamicProgramming.Easy;

public class RangeSumQuery {

    /*

    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    Example:
    Given nums = [-2, 0, 3, -5, 2, -1]

    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3
    Note:
    You may assume that the array does not change.
    There are many calls to sumRange function.

    */

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        RangeSumQuery rangeSumQuery = new RangeSumQuery();
        int[] a = rangeSumQuery.NumArray(nums);
        System.out.println(rangeSumQuery.sumQuery(a, 0, 2));
        System.out.println(rangeSumQuery.sumQuery(a, 2, 5));
        System.out.println(rangeSumQuery.sumQuery(a, 0, 5));
    }

    public int[] NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] a = new int[nums.length + 1];
        a[0] = 0;
        a[1] = nums[0];
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i - 1] + nums[i - 1]; // sum up to previous number and current number
        }
        return a;
    }

    public int sumQuery(int[] a, int i, int j) {
        if (a == null) return 0;
        return a[j + 1] - a[i];
    }

}
