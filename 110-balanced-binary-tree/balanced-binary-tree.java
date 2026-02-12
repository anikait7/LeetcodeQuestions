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
    public int check_balanced(TreeNode root)
    {
        if(root==null)
            return 0;

        int x = check_balanced(root.left);
        int y = check_balanced(root.right);

        if(x==-1 || y==-1)
            return -1;

        if(Math.abs(x-y)>1)
            return -1;
        else
            return Math.max(x,y)+1;
    }

    public boolean isBalanced(TreeNode root) 
    {
        if(check_balanced(root)==-1)
            return false;
        else
            return true;
    }
}