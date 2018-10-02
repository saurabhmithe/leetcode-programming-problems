package Tree.Medium;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    /*

    Given a binary tree, return the inorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
       1
        \
         2
        /
       3

    Output: [1,3,2]

    Follow up: Recursive solution is trivial, could you do it iteratively?

    */

    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.right = two;
        two.left = three;
        List<Integer> result = binaryTreeInorderTraversal.inorderTraversal(root);
        for (Integer i : result) {
            System.out.print(i + "  ");
        }
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list;
    }

}
