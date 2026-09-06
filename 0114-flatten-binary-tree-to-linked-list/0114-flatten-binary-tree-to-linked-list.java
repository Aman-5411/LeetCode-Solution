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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
       if(root == null)     return null;
        TreeNode leftHead = helper(root.left);
        TreeNode rightHead= helper(root.right);

        root.left = null;

        if(leftHead != null) {
            root.right = leftHead;
            TreeNode temp = leftHead;
            while(temp != null && temp.right != null) 
                temp = temp.right;

            temp.right = rightHead;
        }

        else{
            root.right = rightHead;
        }

        return root;
    }
}