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
    int arr[] = new int[10001];
    int depth=0;

    public void tree(int c, TreeNode root)
    {
        arr[c]+=root.val;
        depth=Math.max(c,depth);

        if(root.left==null && root.right==null)
            return ;        

        if(root.left!=null)
            tree(c+1, root.left);

        if(root.right!=null)
            tree(c+1, root.right);
    }

    public int maxLevelSum(TreeNode root) 
    {
        tree(0, root);

        int max=arr[0];     int level=1;

        for(int i=1;i<=depth;i++)
        {   
            if(arr[i]>max)
            {
                max=arr[i];
                level=i+1;
            }
        }

        return level;
    }
}