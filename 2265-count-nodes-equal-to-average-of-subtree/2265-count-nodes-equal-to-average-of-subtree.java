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
    private static int count;
    private int[] helper(TreeNode root) {
        if(root == null)    return new int[]{0,0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int sum = left[0] + right[0] + root.val;
        int nodes = left[1] + right[1] + 1;

        if(sum / nodes == root.val) 
            count++;

        return new int[]{sum, nodes};

    }
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        if(root == null) return 0;
        helper(root);
        return count;
    }
}