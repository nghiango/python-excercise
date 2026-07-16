import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/word-search-ii/
public class E212WordSearchII extends BaseTest {

  class Solution {
    public List<String> findWords(char[][] board, String[] words) {
      List<String> result = new ArrayList<>();
      boolean[][] visited = new boolean[board.length][board[0].length];

      for (String word : words) {
        char[] chars = word.toCharArray();
        boolean found = false;
        outer:
        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[i].length; j++) {
            if (dfs(board, i, j, chars, 0, visited)) {
              found = true;
              break outer;
            }
          }
        }
        if (found) {
          result.add(word);
        }
      }
      return result.stream().sorted().toList();
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

  class Solution2 {
    class TrieNode {
      java.util.Map<Character, TrieNode> children = new java.util.HashMap<>();
      String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
      TrieNode root = new TrieNode();
      for (String word : words) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
          node.children.putIfAbsent(c, new TrieNode());
          node = node.children.get(c);
        }
        node.word = word;
      }

      List<String> result = new ArrayList<>();
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          dfs(board, i, j, root, result);
        }
      }
      return result.stream().sorted().toList();
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
      if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return;
      char c = board[i][j];
      if (c == '#' || !node.children.containsKey(c)) return;

      TrieNode next = node.children.get(c);
      if (next.word != null) {
        result.add(next.word);
        next.word = null;
      }

      board[i][j] = '#';
      dfs(board, i, j - 1, next, result);
      dfs(board, i, j + 1, next, result);
      dfs(board, i - 1, j, next, result);
      dfs(board, i + 1, j, next, result);
      board[i][j] = c;

      if (next.children.isEmpty()) {
        node.children.remove(c);
      }
    }
  }


  public static void main(String[] args) {
    E212WordSearchII test = new E212WordSearchII();
//    test.runAllTests();
    test.runTest(1);
  }

  @Override
  public void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);
    char[][] board = input.next2DArrayInline(char[][].class);
    String[] words = input.nextLineArray(String[].class);
    List<String> expected = Arrays.asList(output.nextLineArray(String[].class));
    Solution2 solution = new Solution2();
    List<String> result = solution.findWords(board, words);
    AssertUtils.assertEquals(result, expected);
  }
}
