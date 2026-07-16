package shared;

public class LinkedListUtils {
  public static ListNode createLinkedList(int[] nums) {
    ListNode previous = null;
    ListNode head = null;
    for (int num : nums) {
      ListNode node = new ListNode(num);
      if (head == null) {
        head = node;
        previous = node;
      } else {
        previous.next = node;
        previous = node;
      }

    }
    return head;
  }

}
