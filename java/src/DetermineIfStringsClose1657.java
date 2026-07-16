import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import shared.AssertUtils;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;

//https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
public class DetermineIfStringsClose1657 extends BaseTest {

  public DetermineIfStringsClose1657() {
    super();
  }

  public static void main(String[] args) {
    DetermineIfStringsClose1657 test = new DetermineIfStringsClose1657();
    test.runAllTests();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    String word1 = input.nextLine();
    String word2 = input.nextLine();

    boolean expected = output.nextBoolean();
    boolean actual = closeStrings(word1, word2);
    AssertUtils.assertEquals(actual, expected);
  }

  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    boolean sameSet = word1.chars().boxed().collect(Collectors.toSet())
        .equals(word2.chars().boxed().collect(Collectors.toSet()));
    if (!sameSet) {
      return false;
    }

    Map<Integer, Integer> word1Map = new HashMap<>();
    word1.chars().forEach(c -> word1Map.merge(c, 1, Integer::sum));
    Map<Integer, Integer> word2Map = new HashMap<>();
    word2.chars().forEach(c -> word2Map.merge(c, 1, Integer::sum));
    int[] sorted1 = word1Map.values().stream().sorted().mapToInt(Integer::intValue).toArray();
    int[] sorted2 = word2Map.values().stream().sorted().mapToInt(Integer::intValue).toArray();
    return Arrays.equals(sorted1, sorted2);
  }

  public boolean closeStringsSimple(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    // Count frequency of each character
    int[] freq1 = new int[26];
    int[] freq2 = new int[26];

    // Track which characters appear
    boolean[] exist1 = new boolean[26];
    boolean[] exist2 = new boolean[26];

    for (char c : word1.toCharArray()) {
      freq1[c - 'a']++;
      exist1[c - 'a'] = true;
    }

    for (char c : word2.toCharArray()) {
      freq2[c - 'a']++;
      exist2[c - 'a'] = true;
    }

    // Condition 1: Same character set
    for (int i = 0; i < 26; i++) {
      if (exist1[i] != exist2[i]) {
        return false;
      }
    }

    // Sort frequencies to compare multisets
    Arrays.sort(freq1);
    Arrays.sort(freq2);

    // Condition 2: Same frequency multiset
    for (int i = 0; i < 26; i++) {
      if (freq1[i] != freq2[i]) {
        return false;
      }
    }

    return true;
  }
}
