import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
public class MaxConsecutiveOnesIII extends BaseTest {
  public MaxConsecutiveOnesIII() {
    super();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    int[] nums = input.nextLineArray(int[].class);
    int k = input.nextInt();
    int expected = output.nextInt();
    int actual = longestOnes(nums, k);
    AssertUtils.assertEquals(actual, expected);
  }

  public int longestOnes(int[] nums, int k) {
    int countZero = 0;
    int max = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        countZero++;
      }
      while (countZero > k) {
        if (nums[left] == 0) {
          countZero--;
        }
        left++;
      }
      max = Math.max(max, right - left + 1);

    }

    return Math.max(max, countZero);
  }

  public static void main(String[] args) {
    MaxConsecutiveOnesIII test = new MaxConsecutiveOnesIII();
    test.runAllTests();
    // test.runTest(2);
  }
}
