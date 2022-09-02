class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return list;
        q.add(root);
        double sum=0;
        while(!q.isEmpty()){
            int size= q.size();
            sum=0;
            for(int i=0;i<size; i++){
                TreeNode node= q.remove();
                sum+=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            sum/=size;
            list.add(sum);
        }
        return list;
    }
}
