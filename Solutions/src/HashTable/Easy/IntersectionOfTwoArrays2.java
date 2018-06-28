package HashTable.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {

    /*

    Given two arrays, write a function to compute their intersection.

    Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

    Note:
    Each element in the result should appear as many times as it shows in both arrays.

    The result can be in any order.
    Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that
    you cannot load all elements into the memory at once?

    */


    /**
     * Since the order does not matter here, we can use a HashMap.
     * It does not matter which array is shorter since the intersection
     * would always be less than or equal to length of the shorter array.
     * We iterate over the first array and put the elements in the HashMap
     * along with incrementing the count if seen more than once.
     * We then iterate over the second array and if we see the same element
     * in the HashMap, we add it to our list and decrement the count in the HashMap.
     * In the end, we return an array representation of the elements in the list.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 8ms
     * Runtime beats 43.18% of Java submissions
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] arr = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
            arr[index++] = num;
        }
        return arr;
    }

}
