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
    int maxLength;
    public int diameterOfBinaryTree(TreeNode root) {
        maxLength = 0;

        maxLengthR(root);
        return maxLength;
    }
    
    public int maxLengthR(TreeNode root){
        if(root == null)return 0;

        int leftL = maxLengthR(root.left);
        int rightL = maxLengthR(root.right);

        maxLength = Math.max(maxLength, leftL+rightL);

        return Math.max(leftL, rightL)+1;
    }
}
