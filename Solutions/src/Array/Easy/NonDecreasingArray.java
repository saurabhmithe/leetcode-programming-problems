package Array.Easy;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] a = {2, 3, 3, 2, 4};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean result = nonDecreasingArray.checkPossibility(a);
        System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) return true;
        int faultyIndex = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (faultyIndex != -1) return false;
                faultyIndex = i;
            }
        }

        if (faultyIndex == -1) return true; // non-decreasing array
        if (faultyIndex == 0 || faultyIndex == nums.length - 2) return true; // first or last
        if (nums[faultyIndex - 1] <= nums[faultyIndex + 1]) return true; // can flat out first from faulty pair
        if (nums[faultyIndex] <= nums[faultyIndex + 2]) return true; // can flat out second from faulty pair
        return false;
    }

}
