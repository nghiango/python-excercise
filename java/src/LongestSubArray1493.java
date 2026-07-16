import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

public class LongestSubArray1493 extends BaseTest {
  public LongestSubArray1493() {
    super();
  }

  @Override
  public void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    int[] nums = input.nextLineArray(int[].class);
    int expected = output.nextInt();
    int actual = longestSubarray(nums);
    AssertUtils.assertEquals(actual, expected);
  }

  public int longestSubarray(int[] nums) {
    int countZero = 0;
    int max = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        countZero++;
      }
      while (countZero > 1) {
        if (nums[left] == 0) {
          countZero--;
        }
        left++;
      }
      max = Math.max(max, right - left);
    }
    return max;
  }

  public static void main(String[] args) {
    LongestSubArray1493 test = new LongestSubArray1493();
    test.runAllTests();
  }
}
