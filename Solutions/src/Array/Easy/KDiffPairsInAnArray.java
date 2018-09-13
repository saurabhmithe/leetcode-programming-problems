package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) count += 1;
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count += 1;
                }
            }
        }
        return count;
    }

}
