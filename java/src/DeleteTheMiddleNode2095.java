import shared.AssertUtils;
import shared.BaseTest;
import shared.LinkedListUtils;
import shared.ListNode;
import shared.MyReader;
import shared.TestReader;


public class DeleteTheMiddleNode2095 extends BaseTest {

  public static void main(String[] args) {
    DeleteTheMiddleNode2095 test = new DeleteTheMiddleNode2095();
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
    ListNode actual = deleteMiddle(head);
    AssertUtils.assertEquals(actual, expected);
  }

  public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head.next.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    slow.next = slow.next.next;

    return head;
  }
}
