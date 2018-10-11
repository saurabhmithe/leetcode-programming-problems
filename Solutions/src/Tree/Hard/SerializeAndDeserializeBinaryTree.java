package Tree.Hard;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    /*

    Serialization is the process of converting a data structure or object into a sequence of bits so that it can
    be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed
    later in the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
    serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
    be serialized to a string and this string can be deserialized to the original tree structure.

    Example:

    You may serialize the following tree:

        1
       / \
      2   3
         / \
        4   5

    as "[1,2,3,null,null,4,5]"
    Clarification: The above format is the same as how LeetCode serializes a binary tree.
    You do not necessarily need to follow this format, so please be creative and
    come up with different approaches yourself.

    Note: Do not use class member/global/static variables to store states.
    Your serialize and deserialize algorithms should be stateless.

    */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        root.left = two;
        TreeNode three = new TreeNode(3);
        root.right = three;
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        three.left = four;
        three.right = five;

        SerializeAndDeserializeBinaryTree serializeAndDeserialize = new SerializeAndDeserializeBinaryTree();
        String serialized = serializeAndDeserialize.serialize(root);
        TreeNode deserialized = serializeAndDeserialize.deserialize(serialized);
        serializeAndDeserialize.printTree(root);
    }

    public void printTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    private String rserialize(TreeNode root, String serialized) {
        if (root == null) {
            serialized += "null,";
        } else {
            serialized += String.valueOf(root.val) + ","; // int to string
            serialized = rserialize(root.left, serialized);
            serialized = rserialize(root.right, serialized);
        }
        return serialized;
    }

    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<String>();
        for (String s : data.split(",")) {
            list.add(s);
        }
        return rdeserialize(list);
    }

    private TreeNode rdeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }

}
