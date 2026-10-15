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
    int MaxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int maxSum = maxSumRec(root);
        return MaxSum;
    }
    public int maxSumRec(TreeNode root){
        int maxSum = Integer.MIN_VALUE;
        if(root == null) return maxSum;
        int left = Math.max(0,maxSumRec(root.left));
        int right = Math.max(0,maxSumRec(root.right));

        int currentSum = left + right + root.val;
        MaxSum = Math.max(currentSum , MaxSum);


        return root.val + Math.max(left , right);
    }
}
