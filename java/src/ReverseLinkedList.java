import shared.AssertUtils;
import shared.BaseTest;
import shared.LinkedListUtils;
import shared.ListNode;
import shared.MyReader;
import shared.TestReader;

public class ReverseLinkedList extends BaseTest {

  public static void main(String[] args) {
    ReverseLinkedList test = new ReverseLinkedList();
    test.runAllTests();
//    test.runTest(2);
  }
  @Override
  public void runTest(String testName, TestReader testReader) {
    MyReader input = testReader.readInput(testName);
    MyReader output = testReader.readOutput(testName);
    int[] nums = input.nextLineArray(int[].class);
    ListNode head = LinkedListUtils.createLinkedList(nums);
    int[] expected = output.nextLineArray(int[].class);
    ListNode actual = reverseList(head);
    AssertUtils.assertEquals(actual, expected);
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode prev = null;
    while (head.next != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    head.next = prev;
    return head;
  }
  // next: 2, prev: null, head.next: null, prev: 1, head: 2
  // next: 3, prev: 1, head.next: 1, prev: 2, head: 3
  // next: 4, prev: 2, head.next: 2, prev: 3, head: 4
  // next: 5, prev: 3, head.next: 3, prev: 4, head: 5
  // next: null, prev: 4, head.next: 4, prev: 5, head: 5
  // return head: 5

}
