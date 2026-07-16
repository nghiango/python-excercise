import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class E208ImplementTries extends BaseTest {
  class TrieSimpleVersion {
    private List<String> words;
    public TrieSimpleVersion() {
      words = new ArrayList<>();
    }

    public void insert(String word) {
      words.add(word);
    }

    public boolean search(String word) {
      return words.contains(word);
    }

    public boolean startsWith(String prefix) {
      return words.stream().anyMatch(word -> word.startsWith(prefix));
    }
  }


  class Trie {

    class CharNode {
     public String value;
     public CharNode[] children;
     public boolean isEndOfWord;

     public CharNode(String value) {
       this.value = value;
       children = new CharNode[26];
       isEndOfWord = false;
     }

     public CharNode getChild(char c) {
       return children[c - 'a'];
     }

     public boolean hasChild(char c) {
       return children[c - 'a'] != null;
     }

     public void setChild(char c, CharNode node) {
       children[c - 'a'] = node;
     }
    }

    private CharNode root;
    public Trie() {
      root = new CharNode("*");
    }

    public void insert(String word) {
      char[] chars = word.toCharArray();
      CharNode node = root;
      for (int i = 0; i < chars.length; i++) {
        char aChar = chars[i];
        boolean isEndOfWord = i == chars.length - 1;
        if (!node.hasChild(aChar)) {
          node.setChild(aChar, new CharNode(String.valueOf(aChar)));
        }
        node = node.getChild(aChar);
        node.isEndOfWord = isEndOfWord || node.isEndOfWord;
      }
    }


    public boolean search(String word) {
      boolean hasWord = false;
      CharNode node = root;
      for (char aChar : word.toCharArray()) {
        if (node.hasChild(aChar)) {
          node = node.getChild(aChar);
        } else {
          return false;
        }
      }
      hasWord = node.isEndOfWord;
      return hasWord;
    }

    public boolean startsWith(String prefix) {
      boolean hasPrefix = true;
      CharNode node = root;
      for (char aChar : prefix.toCharArray()) {
        if (node.hasChild(aChar)) {
          node = node.getChild(aChar);
        } else {
          return false;
        }
      }
      return hasPrefix;
    }
  }

  public static void main(String[] args) {
    E208ImplementTries test = new E208ImplementTries();
    test.runAllTests();
  }


  @Override
  public void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    String[] actions = input.nextLineArray();
    String[][] actionParams = input.nextLineArrayOfArrays();
    Boolean[] expected = output.nextLineArray(Boolean[].class);

    Trie trie = null;
    for (int i = 0; i < actions.length; i++) {
      String action = actions[i];
      if (action.equals("Trie")) {
        trie = new Trie();
        continue;
      }
      if (trie == null) {
        continue;
      }

      switch (action) {
        case "insert" -> trie.insert(actionParams[i][0]);
        case "search" -> AssertUtils.assertEquals(trie.search(actionParams[i][0]), expected[i]);
        case "startsWith" -> AssertUtils.assertEquals(trie.startsWith(actionParams[i][0]), expected[i]);
      }
    }
  }
}

