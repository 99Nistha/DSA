class Solution {
    public void flatten(TreeNode root) {
        TreeNode flat= root;
        while(flat!=null){
            if(flat.left!=null){
                TreeNode prev= flat.left;
                while(prev.right!=null){
                    prev= prev.right;
                }
                prev.right= flat.right;
                flat.right=flat.left;
                flat.left=null;
            }
            flat= flat.right;
        }
    }
}
