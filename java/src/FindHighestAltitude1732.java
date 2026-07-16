import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

public class FindHighestAltitude1732 extends BaseTest {
  public FindHighestAltitude1732() {
    super();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    int[] nums = input.nextLineArray(int[].class);
    int expected = output.nextInt();
    int actual = highestAltitude(nums);
    AssertUtils.assertEquals(actual, expected);
  }

  public int highestAltitude(int[] gain) {
    int max = 0;
    int acc = 0;
    for (int num : gain) {
      acc += num;
      max = Math.max(acc, max);
    }
    return max;
  }

  public static void main(String[] args) {
    FindHighestAltitude1732 test = new FindHighestAltitude1732();
    test.runAllTests();
  }
}
