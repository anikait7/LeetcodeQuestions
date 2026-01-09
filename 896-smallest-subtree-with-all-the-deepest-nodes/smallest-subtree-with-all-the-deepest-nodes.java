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
    public boolean recursive(TreeNode root, List<TreeNode> list, int num)
    {
        if(root.val==num)
            return true;
        else
        {
            if(root.left!=null)
            {
                list.add(root);
                if(recursive(root.left,list,num))
                    return true;

                list.remove(list.size()-1);
            }

            if(root.right!=null)
            {
                list.add(root);
                if(recursive(root.right,list,num))
                    return true;

                list.remove(list.size()-1);
            }
        }        
        return false;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) 
    {
        if(root.left==null && root.right==null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode first=null;
        TreeNode last=null;

        while(!queue.isEmpty())
        {
            int x=queue.size();
            for(int i=0;i<x;i++)
            {
                TreeNode temp = queue.poll();

                if(temp.left!=null)
                    queue.add(temp.left);

                if(temp.right!=null)
                    queue.add(temp.right);
                
                if(i==0)
                    first=temp;

                if(i==x-1)
                    last=temp;
            }
        }

        if(first.val==last.val)
            return last;

        List<TreeNode> temp1 = new ArrayList<>();
        List<TreeNode> temp2 = new ArrayList<>();

        boolean flag = recursive(root,temp1,first.val);
        flag = recursive(root,temp2,last.val);

        for(int i=temp1.size()-1;i>=0;i--)
            if(temp1.get(i).val==temp2.get(i).val)
                return temp1.get(i);

        return root;
    }
}