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
    int index = 0;
    int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        check(root, k);
        return value;
    }

    public void check(TreeNode root, int k){
        if(root == null) return;
        check(root.left, k);
        index++;
        if(index == k){
            value = root.val;
            index++;
            return;
        };
        check(root.right, k);
    }
}
