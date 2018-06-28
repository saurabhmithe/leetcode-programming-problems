package HashTable.Easy;

public class CountPrimes {

    /*

    Count the number of prime numbers less than a non-negative number, n.

    */

    /**
     * We maintain a boolean array of size equal to the upper bound number.
     * Starting from 2, we mark all the multiples of 2 as "not prime" in the array.
     * Then we repeat the process for 3, 4, 5, and so on.
     * If we come across a number which is not marked as not prime in the array,
     * we increment the count since it is a prime.
     * We return the count when we have seen all the elements up to the upper bound.
     * <p>
     * Time Complexity - O(n^2)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 25ms
     * Runtime beats 85.54% of Java submissions
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

}
