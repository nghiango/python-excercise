import shared.BaseTest;
import shared.ListNode;
import shared.TestReader;

//https://leetcode.com/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
public class OddEvenLinkedList328 extends BaseTest {
  @Override
  public void runTest(String testName, TestReader testReader) {

  }

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }

}
