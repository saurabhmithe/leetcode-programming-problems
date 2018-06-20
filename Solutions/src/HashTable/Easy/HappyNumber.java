package HashTable.Easy;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class HappyNumber {

    /*

    Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer,
    replace the number by the sum of the squares of its digits, and repeat the process until the number
    equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy numbers.

    Example:

    Input: 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1

     */

    /**
     * This is an iterative approach to this problem.
     * We have two exit conditions. One is where the sum is 1 and we return true.
     * Other is where the sum has already been seen earlier where we return false.
     * Every time we compute the sum of the digits, we check if it is 1 or seen earlier.
     * If neither, then we put the number as key and the sum as value.
     * We use this value as the new number and repeat the process until one of the exit
     * conditions is satisfied.
     * <p>
     * Time Complexity - O(d * k) where n is the number od digits in the number & k is the times sum is calculated.
     * Space Complexity - O(k).
     * <p>
     * Runtime on LeetCode - 6ms
     * Runtime beats 48.39% of Java submissions.
     */
    public boolean isHappy(int n) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        while (true) {
            int sum = 0;
            int key = n;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) return true;
            else {
                if (hashTable.containsKey(key)) return false;
                hashTable.put(key, sum);
                n = sum;
            }
        }
    }


    /**
     * This is a recursive approach to this problem.
     * We are using a HashSet to keep a track of the sums we have seen previously.
     * The two base cases are where we either see a sum of 1 or a sum that had been seen earlier.
     * If neither, we store the sum in the HashSet.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 4ms
     * Runtime beats 80.16% of Java submissions.
     */
    public boolean isHappyHashSet(int n) {

        Set<Integer> set = new HashSet<Integer>();
        boolean res = operate(n, set);

        return res;
    }

    /* Part of isHappyHashSet() */
    private int calculate(int n) {
        int sum = 0;

        while (n > 0) {
            int num = n % 10;
            sum = sum + (num * num);
            n = n / 10;
        }

        return sum;
    }

    /* Part of isHappyHashSet() */
    private boolean operate(int n, Set<Integer> set) {
        int sum = calculate(n);
        if (set.contains(sum)) {
            return false;
        }
        set.add(sum);

        if (sum == 1) {
            return true;
        } else if (sum * sum < 10) {
            return false;
        }
        return operate(sum, set);
    }

}
