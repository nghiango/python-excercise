import java.util.Stack;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75
public class DecodeString394 extends BaseTest {

  public DecodeString394() {
    super();
  }

  public static void main(String[] args) {
    DecodeString394 test = new DecodeString394();
    test.runAllTests();
//    test.runTest(3);
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    String s = input.nextLine();
    String expected = output.nextLine();
    String actual = decodeString(s);
    AssertUtils.assertEquals(actual, expected);
  }

  public String decodeString(String s) {
    Stack<String> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int k = 0;
    for (char c : s.toCharArray()) {
      StringBuilder con = new StringBuilder();
      boolean shouldAdd = true;
      if (c == ']') {
        shouldAdd = false;
        do {
          con.append(stack.pop());
        } while (!stack.isEmpty() && !stack.peek().equals("["));
        if (stack.peek().equals("[")) {
          stack.pop();
        }
        StringBuilder number = new StringBuilder();
        while (!stack.isEmpty() && isNumber(stack.peek())) {
          number.append(stack.pop());
        }
       k = Integer.parseInt(number.reverse().toString());
       stack.push(con.toString().repeat(Math.max(0, k)));
      }
      if (shouldAdd) {
        stack.push(String.valueOf(c));
      }
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

  private boolean isNumber(String c) {
    try {
      Integer.parseInt(c);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
