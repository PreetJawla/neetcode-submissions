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
    int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepthRec(root);
        return maxLength;
    }
    public int maxDepthRec(TreeNode root){
        if(root == null) return 0;
        int leftMax = maxDepthRec(root.left);
        int rightMax = maxDepthRec(root.right);
        maxLength = Math.max((leftMax + rightMax), maxLength);
        return Math.max(leftMax, rightMax)+1;
    }
}


