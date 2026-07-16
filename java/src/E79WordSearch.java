import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/word-search/
public class E79WordSearch extends BaseTest {

  class Solution {
    public boolean exist(char[][] board, String word) {
      boolean[][] visited = new boolean[board.length][board[0].length];
      return goThroughBoard(board, word.toCharArray(), 0, visited);
    }

    private boolean goThroughBoard(char[][] board, char[] chars, int charIndex, boolean[][] visited) {
      boolean hasValue = false;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (dfs(board, i, j, chars, charIndex, visited)) {
            hasValue = true;
            break;
          }
        }
      }
      return hasValue;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int charIndex, boolean[][] visited) {
      if (charIndex >= chars.length) {
        return true;
      }
      if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
        return false;
      }
      if (visited[i][j] || board[i][j] != chars[charIndex]) {
        return false;
      }
      visited[i][j] = true;
      boolean found = dfs(board, i, j - 1, chars, charIndex + 1, visited)
          || dfs(board, i, j + 1, chars, charIndex + 1, visited)
          || dfs(board, i - 1, j, chars, charIndex + 1, visited)
          || dfs(board, i + 1, j, chars, charIndex + 1, visited);
      visited[i][j] = false;
      return found;
    }
  }

  public static void main(String[] args) {
    E79WordSearch test = new E79WordSearch();
//    test.runAllTests();
    test.runTest(2);
  }

  @Override
  public void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);
    char[][] board = input.next2DArrayInline(char[][].class);
    String word = input.nextLine();
    boolean expected = output.nextBoolean();
    Solution solution = new Solution();
    boolean result = solution.exist(board, word);
    AssertUtils.assertEquals(result, expected);
  }
}
