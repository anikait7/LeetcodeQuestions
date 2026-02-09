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
        List<Integer> list = new ArrayList<>();

        public void traverse(TreeNode root)
        {
            if(root.left!=null)
                traverse(root.left);

            list.add(root.val);

            if(root.right!=null)
                traverse(root.right);
        }

        public TreeNode create(int lb, int ub)
        {
            if(lb>ub)
                return null;

            int mid = (lb+ub)/2;

            TreeNode root = new TreeNode(list.get(mid));
            root.left = create(lb,mid-1);
            root.right = create(mid+1,ub);

            return root;
        }

        public TreeNode balanceBST(TreeNode root) 
        {
            traverse(root);

            return create(0,list.size()-1);
        }
    }