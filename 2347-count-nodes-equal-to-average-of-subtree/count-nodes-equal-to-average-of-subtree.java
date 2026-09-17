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
    int count=0;

    public int [] recursive(TreeNode temp)
    {
        if(temp==null)
            return new int[]{0,0};

        int l[] = recursive(temp.left);
        int r[] = recursive(temp.right);

        int sum = l[0]+r[0]+temp.val;
        int c = l[1]+r[1]+1;

        if(sum/c==temp.val)
            count++;

        return new int[]{sum,c};
    }

    public int averageOfSubtree(TreeNode root) 
    {
        int x[] = recursive(root);

        return count;
    }
}