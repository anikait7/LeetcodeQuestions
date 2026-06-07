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
    public TreeNode createBinaryTree(int[][] descriptions) 
    {
        Map<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<descriptions.length;i++)
        {
            TreeNode p;
            TreeNode q = new TreeNode(descriptions[i][1]);

            set.add(descriptions[i][0]);

            if(!map.containsKey(descriptions[i][0]))
            {
                p = new TreeNode(descriptions[i][0]);
                map.put(descriptions[i][0],p);
            }
            else
                p=map.get(descriptions[i][0]);
            
            if(!map.containsKey(descriptions[i][1]))
            {
                q = new TreeNode(descriptions[i][1]);
                map.put(descriptions[i][1],q);
            }
            else
                q=map.get(descriptions[i][1]);

            if(descriptions[i][2]==1)
                p.left=q;
            else
                p.right=q;
        }

        for(int i=0;i<descriptions.length;i++)
            set.remove(descriptions[i][1]);

        return map.get(set.iterator().next());
    }
}