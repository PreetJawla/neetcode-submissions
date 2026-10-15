/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        treeBalance(root);
        return balance;
    }
    public int treeBalance(TreeNode root){
        if(root == null || balance == false) return 0;

        int leftMax = treeBalance(root.left);
        int rightMax = treeBalance(root.right);
        if(Math.abs(leftMax - rightMax)> 1) balance = false;
        return Math.max(leftMax, rightMax)+1;
    }
}
