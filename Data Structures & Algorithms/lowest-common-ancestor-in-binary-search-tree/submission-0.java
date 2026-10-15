class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If both p and q are smaller than root, LCA lies in left
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both p and q are greater than root, LCA lies in right
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If root is between p and q, or equal to one of them, it's the LCA
        else {
            return root;
        }
    }
}
