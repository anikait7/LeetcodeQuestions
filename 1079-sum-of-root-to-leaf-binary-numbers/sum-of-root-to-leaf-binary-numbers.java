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
    List<String> list = new ArrayList<>();

    public void compute(TreeNode root, StringBuilder sb)
    {
        if(root.left==null && root.right==null)
        {
            sb.append(root.val);
            list.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);

            return ;
        }

        sb.append(root.val);

        if(root.left!=null)
            compute(root.left,sb);

        if(root.right!=null)
            compute(root.right,sb);

        sb.deleteCharAt(sb.length()-1);
    }

    public int sumRootToLeaf(TreeNode root) 
    {
        compute(root, new StringBuilder());
        int sum=0;

        for(int i=0;i<list.size();i++)
        {
            int c=0;  
            for(int j=list.get(i).length()-1;j>=0;j--)
            {
                sum+=(list.get(i).charAt(j)-'0')*Math.pow(2,c++);
            }
        }

        return sum;
    }
}