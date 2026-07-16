import java.util.Stack;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

public class AsteroidCollision735 extends BaseTest {

  public AsteroidCollision735() {
    super();
  }

  public static void main(String[] args) {
    AsteroidCollision735 test = new AsteroidCollision735();
    test.runAllTests();
//    test.runTest(4);
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    int[] asteroids = input.nextLineArray(int[].class);
    int[] expected = output.nextLineArray(int[].class);
    int[] actual = asteroidCollision2(asteroids);
    AssertUtils.assertEquals(actual, expected);
  }

  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int asteroid : asteroids) {
      stack.push(asteroid);
      while (!stack.isEmpty() && stack.peek() < 0 && stack.size() > 1) {
        int current = stack.pop();
        int prevCurrent = stack.pop();
        if (current <= 0 && prevCurrent <= 0 || current >= 0 && prevCurrent >= 0) {
          stack.push(prevCurrent);
          stack.push(current);
          break;
        }

        if (prevCurrent > -current) {
          stack.push(prevCurrent);
          break;
        }
        if (prevCurrent < -current) {
          stack.push(current);
        }
      }
    }
    return stack.stream().mapToInt(Integer::intValue).toArray();
  }
  public int[] asteroidCollision2(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int current : asteroids) {
      boolean isCurrentDestroyed = false;
      while (!stack.isEmpty() && current < 0 && stack.peek() > 0) {
       int prev = stack.peek();
       if (prev < -current) {
         stack.pop();
       } else if (prev == -current) {
         stack.pop();
         isCurrentDestroyed = true;
         break;
       } else {
         isCurrentDestroyed = true;
         break;
       }
      }
      if (!isCurrentDestroyed) {
        stack.push(current);
      }
    }
    return stack.stream().mapToInt(Integer::intValue).toArray();
  }
}
