class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return makeTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    public TreeNode makeTree(int[] preorder, int preStart, int preEnd, 
                             int[] inorder, int inStart, int inEnd, 
                             Map<Integer, Integer> map){
        if(preStart>preEnd || inStart>inEnd) return null;
        
        TreeNode root= new TreeNode(preorder[preStart]);
        int inRoot= map.get(root.val);
        int numsLeft= inRoot- inStart;
        root.left= makeTree(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, map);
        root.right= makeTree(preorder, preStart+1+numsLeft, preEnd, inorder, inRoot+1, inEnd, map);    
        return root;
    }
}
/*
preorder-> first one is root
inorder-> find the root in here, all in left comes in left side, all in right is in right side
tc-> o(n)+ o(logn)
sc: o(n)
*/
