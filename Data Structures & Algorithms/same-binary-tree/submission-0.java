class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(p);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(q);

        while(!q1.isEmpty() || !q2.isEmpty()){
            TreeNode temp1 = q1.poll();
            TreeNode temp2 = q2.poll();
            if(temp1 == null && temp2 == null) continue;
            if(temp1 == null || temp2 == null) return false;
            if(temp1.val == temp2.val){
                q1.add(temp1.left);
                q1.add(temp1.right);
                q2.add(temp2.left);
                q2.add(temp2.right);
            }else{
                return false;
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}