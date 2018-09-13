package Array.Easy;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 0 || nums.length == 1) return 0;

        int end = -2;
        int start = -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            if (nums[i] < max) end = i;
        }

        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            if (nums[i] > min) start = i;
        }

        return end - start + 1;
    }

}
