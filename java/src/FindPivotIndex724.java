import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

public class FindPivotIndex724 extends BaseTest {

  public FindPivotIndex724() {
    super();
  }

  public static void main(String[] args) {
    FindPivotIndex724 test = new FindPivotIndex724();
    test.runAllTests();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    int[] nums = input.nextLineArray(int[].class);
    int expected = output.nextInt();
    int actual = pivotIndex(nums);
    AssertUtils.assertEquals(actual, expected);
  }

  public int pivotIndex(int[] nums) {
    int total = 0;
    for (int num : nums) {
      total += num;
    }

    int prevLeft = 0;
    int prevRight = 0;
    int foundIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      if (i > 0) {
        prevLeft += nums[i - 1];
      }
      prevRight = total - nums[i] - prevLeft;
      if (prevLeft == prevRight) {
        foundIndex = i;
        break;
      }
    }
    return foundIndex;
  }
}
