package Tree.Easy;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public boolean isSymmetricRecursive(TreeNode root) {
        return isMirrorRecursive(root, root);
    }

    public boolean isMirrorRecursive(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        return (r1.val == r2.val) && isMirrorRecursive(r1.left, r2.right) && isMirrorRecursive(r1.right, r2.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
