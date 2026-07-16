import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
public class UniqueNumberOccurrences1207 extends BaseTest {

  public UniqueNumberOccurrences1207() {
    super();
  }

  public static void main(String[] args) {
    UniqueNumberOccurrences1207 test = new UniqueNumberOccurrences1207();
    test.runAllTests();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    int[] arr = input.nextLineArray(int[].class);
    boolean expected = output.nextBoolean();
    boolean actual = uniqueOccurrences(arr);
    AssertUtils.assertEquals(actual, expected);
  }

  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : arr) {
      map.merge(num, 1, Integer::sum);
    }

    Set<Integer> occurrences = new HashSet<>();
    for (int value: map.values()) {
      if (!occurrences.add(value)) {
        return false;
      }
    }
    return true;
  }
}
