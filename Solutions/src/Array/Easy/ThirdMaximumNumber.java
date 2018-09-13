package Array.Easy;

public class ThirdMaximumNumber {

    public static void main(String[] args) {
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
        int[] a = {1, 2, -2147483648};
        int thirdMax = thirdMaximumNumber.thirdMax(a);
        System.out.println(thirdMax);
    }

    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == firstMax || nums[i] == secondMax || nums[i] == thirdMax) continue;
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];

            } else if (nums[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        if (thirdMax == Long.MIN_VALUE) return (int) Math.max(firstMax, secondMax);
        else return (int) thirdMax;
    }

}
