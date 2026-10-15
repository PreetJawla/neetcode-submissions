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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }
    public int dfs(TreeNode root){
        if(balanced == false)return 0;

        if(root == null)return 0;

        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);

        if(Math.abs(left - right) < 2)return Math.max(left, right);
        else{
            balanced = false;
        }
        return 0;

    }
}
