import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import shared.BaseTest;
import shared.MyReader;
import shared.TestReader;
import shared.AssertUtils;

//https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
public class FindDifferenceTwoArrays2215 extends BaseTest {

  public FindDifferenceTwoArrays2215() {
    super();
  }

  private static class Counter {
    private final int num;
    private boolean seenInFirst;
    private boolean seenInSecond;

    Counter(int num) {
      this.num = num;
    }

    void markFirst() { seenInFirst = true; }
    void markSecond() { seenInSecond = true; }

    boolean onlyInFirst() { return seenInFirst && !seenInSecond; }
    boolean onlyInSecond() { return seenInSecond && !seenInFirst; }
  }

  public static void main(String[] args) {
    FindDifferenceTwoArrays2215 test = new FindDifferenceTwoArrays2215();
    test.runAllTests();
  }

  @Override
  protected void runTest(String testName, TestReader reader) {
    MyReader input = reader.readInput(testName);
    MyReader output = reader.readOutput(testName);

    int[] nums1 = input.nextLineArray(int[].class);
    int[] nums2 = input.nextLineArray(int[].class);

    int[] out1 = output.nextLineArray(int[].class);
    int[] out2 = output.nextLineArray(int[].class);

    List<List<Integer>> diff = findDifference(nums1, nums2);
    AssertUtils.assertEquals(diff.get(0), out1);
    AssertUtils.assertEquals(diff.get(1), out2);
  }

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Map<Integer, Counter> map = new HashMap<>();

    for (int num : nums1) {
      map.computeIfAbsent(num, Counter::new).markFirst();
    }

    for (int num : nums2) {
      map.computeIfAbsent(num, Counter::new).markSecond();
    }

    List<Integer> only1 = new ArrayList<>();
    List<Integer> only2 = new ArrayList<>();

    for (Counter c : map.values()) {
      if (c.onlyInFirst()) {
        only1.add(c.num);
      }
      if (c.onlyInSecond()) {
        only2.add(c.num);
      }
    }

    return List.of(only1, only2);
  }

  public List<List<Integer>> findDifferenceSimple(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (int n : nums1) set1.add(n);
    for (int n : nums2) set2.add(n);

    Set<Integer> only1 = new HashSet<>(set1);
    only1.removeAll(set2);

    Set<Integer> only2 = new HashSet<>(set2);
    only2.removeAll(set1);

    return List.of(
        new ArrayList<>(only1),
        new ArrayList<>(only2)
    );
  }
}
