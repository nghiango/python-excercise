import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

public class EqualRowAndColumn2352 extends BaseTest {

  public EqualRowAndColumn2352() {
    super();
  }

  public static void main(String[] args) {
    EqualRowAndColumn2352 test = new EqualRowAndColumn2352();
    test.runAllTests();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    int[][] grid = input.next2DArray(int[][].class);
    int expected = output.nextInt();
    int actual = equalPairs(grid);
    AssertUtils.assertEquals(actual, expected);
  }

  public int equalPairs(int[][] grid) {
    Map<String, Integer> rowMap = new HashMap<>();

    int amount = 0;
    for (int[] row : grid) {
      String rowKey = Arrays.toString(row);
      rowMap.put(rowKey, rowMap.getOrDefault(rowKey, 0) + 1);
    }

    for (int i = 0; i < grid[0].length; i++) {
      int[] col = new int[grid.length];
      for (int j = 0; j < grid.length; j++) {
        col[j] = grid[j][i];
      }

      String colKey = Arrays.toString(col);
      if (rowMap.containsKey(colKey)) {
        amount += rowMap.get(colKey);
      }
    }

    return amount;
  }
}
