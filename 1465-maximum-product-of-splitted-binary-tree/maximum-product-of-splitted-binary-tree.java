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
    long max=0;
    long total_sum=0;

    public void sum(TreeNode root)
    {
        total_sum+=root.val;

        if(root.left==null && root.right==null)
            return ;

        if(root.left!=null)
            sum(root.left);

        if(root.right!=null)
            sum(root.right);
    }

    public long calc(TreeNode root)
    {
        if(root == null)
            return 0L;

        long left = calc(root.left);
        long right = calc(root.right);

        long subtreeSum = left+right+root.val;

        max = Math.max(max, subtreeSum*(total_sum-subtreeSum));

        return subtreeSum;
    }

    public int maxProduct(TreeNode root) 
    {
        sum(root);
        calc(root);

        return (int)(max%1000000007);
    }
}