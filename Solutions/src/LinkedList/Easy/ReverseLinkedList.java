package LinkedList.Easy;

import LinkedList.ListNode;

public class ReverseLinkedList {

    /*

    Reverse a singly linked list.

    Example:
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    A linked list can be reversed either iteratively or recursively. Could you implement both?

    */

    /**
     * We make use if temporary references prev, next, and current.
     * We are repeating the same process again and again iteratively as follows.
     * Cache the next node of current node.
     * Make the next node previous.
     * Make the previous node as current.
     * Make the next node the new current.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 0ms
     * Runtime beats 100% of Java submissions
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
}
