import java.util.List;
import org.junit.Assert;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
public class MaximumNumberOfVowels extends BaseTest {
  public MaximumNumberOfVowels() {
    super();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    String string = input.nextLine();
    int k = input.nextInt();

    int expected = Integer.parseInt(output.nextLine());
    int actual = maxVowels(string, k);
    AssertUtils.assertEquals(actual, expected);
  }

  private static int maxVowels(String s, int k) {
    List<String> vowels = List.of("a", "e", "i", "o", "u");
    int count = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (vowels.contains(String.valueOf(s.charAt(i)))) {
        count++;
      }
      if (i >= k) {
        if (vowels.contains(String.valueOf(s.charAt(i - k)))) {
          count--;
        }
      }
      max = Math.max(max, count);
    }

    return Math.min(max, k);
  }

  public static void main(String[] args) {
    MaximumNumberOfVowels vowelCounter = new MaximumNumberOfVowels();
    vowelCounter.runAllTests();
  }
}
