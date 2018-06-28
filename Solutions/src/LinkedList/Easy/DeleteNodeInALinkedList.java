package LinkedList.Easy;

import LinkedList.ListNode;

public class DeleteNodeInALinkedList {

    /*

    Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

    Given linked list -- head = [4,5,1,9], which looks like following:

    4 -> 5 -> 1 -> 9

    Example 1:
    Input: head = [4,5,1,9], node = 5
    Output: [4,1,9]
    Explanation: You are given the second node with value 5, the linked list
                 should become 4 -> 1 -> 9 after calling your function.

    Example 2:
    Input: head = [4,5,1,9], node = 1
    Output: [4,5,9]
    Explanation: You are given the third node with value 1, the linked list
                 should become 4 -> 5 -> 9 after calling your function.

    Note:
    The linked list will have at least two elements.
    All of the nodes' values will be unique.
    The given node will not be the tail and it will always be a valid node of the linked list.
    Do not return anything from your function.

    */

    /**
     * This is a rather intuitive approach once we get the hang of it.
     * Instead of deleting current node, we copy the value of the next node
     * to the current node and delete the current node instead.
     * This is because we do not have access to the previous node which is required
     * to perform this delete operation in the traditional way.
     * <p>
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 1ms
     * Runtime beats 100% of Java submissions
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
