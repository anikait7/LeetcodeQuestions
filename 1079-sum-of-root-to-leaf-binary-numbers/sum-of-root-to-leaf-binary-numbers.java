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

class Solution 
{
    public int compute(TreeNode root, int depth)
    {
        if(root==null)
            return 0;

        depth = (depth << 1) | root.val;

        if(root.left==null && root.right==null)
            return depth;
        
        return compute(root.left,depth) + compute(root.right,depth);
    }

    public int sumRootToLeaf(TreeNode root) 
    {
        return compute(root,0);
    }
}