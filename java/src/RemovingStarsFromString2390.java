import java.util.Stack;
import java.util.stream.Collectors;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

public class RemovingStarsFromString2390 extends BaseTest {

  public RemovingStarsFromString2390() {
    super();
  }

  public static void main(String[] args) {
    RemovingStarsFromString2390 test = new RemovingStarsFromString2390();
    test.runAllTests();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    String s = input.nextLine();
    String expected = output.nextLine();
    String actual = removeStars(s);
    AssertUtils.assertEquals(actual, expected);
  }

  public String removeStars(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '*') {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.stream().map(Object::toString).collect(Collectors.joining());
  }
}
