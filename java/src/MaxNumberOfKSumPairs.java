import java.util.HashMap;
import shared.AssertUtils;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
public class MaxNumberOfKSumPairs {
  public int maxOperations(int[] nums, int k) {
    int count = 0;
    // The key is complement, and the value is the number of times this complement
    // has occurred
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      // find complement and then add this complement to map
      int complement = k - num;

      // if the value > 0, it means we found a pairs, and reduce one pair, and
      // increase the count.
      if (map.getOrDefault(complement, 0) > 0) {
        count++;
        map.put(complement, map.getOrDefault(complement, 0) - 1);
      } else {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
    }
    return count;
  }

  // public static void main(String[] args) {
  // MaxNumberOfKSumPairs max = new MaxNumberOfKSumPairs();
  // int[] nums = {1,2,3,4};
  // int k = 5;
  // AssetUtils.assertEquals(max.maxOperations(nums, k), 2);
  // }

  public static void main(String[] args) {
    MaxNumberOfKSumPairs max = new MaxNumberOfKSumPairs();
    int[] nums = { 3, 1, 3, 4, 3 };
    int k = 6;
    AssertUtils.assertEquals(max.maxOperations(nums, k), 1);
  }
}
