import java.util.ArrayDeque;
import java.util.Queue;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
public class Dota2Senate649 extends BaseTest {

  public static void main(String[] args) {
    Dota2Senate649 test = new Dota2Senate649();
    test.runAllTests();
//    test.runTest(3);
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    String senate = input.nextLine();
    String expected = output.nextLine();
    String actual = predictPartyVictory(senate);
    AssertUtils.assertEquals(actual, expected);
  }

  public String predictPartyVictory(String senate) {
    Queue<Integer> radiant = new ArrayDeque<>();
    Queue<Integer> dire = new ArrayDeque<>();
    for (int i = 0; i < senate.length(); i++) {
      if (senate.charAt(i) == 'R') {
        radiant.add(i);
      } else {
        dire.add(i);
      }
    }
    while (!radiant.isEmpty() && !dire.isEmpty()) {
      int r = radiant.poll();
      int d = dire.poll();
      if (r > d) {
        // + senate.length() to simulate the next round with the same position
        dire.add(d + senate.length());
      } else {
        radiant.add(r + senate.length());
      }
    }
    return dire.isEmpty() ? "Radiant" : "Dire";
  }
}
