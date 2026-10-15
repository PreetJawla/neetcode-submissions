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
    int[] levels = new int[101];

    public List<Integer> rightSideView(TreeNode root) {
        Arrays.fill(levels, -111);
        dfs(root, 0);

        List<Integer> result = new ArrayList<>();
        for (int val : levels) {
            if (val == -111) break;
            result.add(val);
        }
        return result;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null) return;

        if (levels[level] == -111) {
            levels[level] = root.val;
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}

