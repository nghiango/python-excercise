import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/design-add-and-search-words-data-structure
public class E211WordDictionary extends BaseTest {

  class WordDictionary {

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

    public WordDictionary() {
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
      return searchFromNode(root, word);
    }

    private boolean searchFromNode(CharNode fromNode, String word) {
      boolean hasWord;
      CharNode node = fromNode;
      int i = 0;
      for (char aChar : word.toCharArray()) {
        if (aChar == '.') {
          for (CharNode child : node.children) {
            if (child != null) {
              String newWord = word.substring(i+1);
              boolean result = searchFromNode(child, newWord);
              if (result) {
                return true;
              }
            }
          }
          return false;
        }
        if (node.hasChild(aChar)) {
          node = node.getChild(aChar);
        } else {
          return false;
        }
        i++;
      }
      hasWord = node.isEndOfWord;
      return hasWord;
    }
  }

  public static void main(String[] args) {
    E211WordDictionary test = new E211WordDictionary();
//    test.runAllTests();
    test.runTest(2);
  }


  @Override
  public void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    String[] actions = input.nextLineArray();
    String[][] actionParams = input.nextLineArrayOfArrays();
    Boolean[] expected = output.nextLineArray(Boolean[].class);

    WordDictionary wordDictionary = null;
    for (int i = 0; i < actions.length; i++) {
      String action = actions[i];
      if (action.equals("WordDictionary")) {
        wordDictionary = new WordDictionary();
        continue;
      }
      if (wordDictionary == null) {
        continue;
      }

      switch (action) {
        case "addWord" -> wordDictionary.insert(actionParams[i][0]);
        case "search" ->
            AssertUtils.assertEquals(wordDictionary.search(actionParams[i][0]), expected[i]);
      }
    }
  }
}

