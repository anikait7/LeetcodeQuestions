class Solution 
{
    public int jump(int[] nums) 
    {
        int n = nums.length;
        int jump[] = new int[n];

        jump[0]=nums[0];

        for(int i=1;i<n;i++)
        {
            int x = Math.min(i+nums[i],n);
            jump[i]=Math.max(x,jump[i-1]);
        }

        //  2   3   1   1   4
        //  2   4   3   3   5

        //initializing everything
        int count=0;        
        int curr=0;
        int max_reachable=0;

        for(int i=0;i<n;i++)
        {
            if(i>curr)
            {
                count++;
                curr=max_reachable;
            }

            if(curr>=n-1)
                return count;

            max_reachable=Math.max(max_reachable,jump[i]);
        }

        return -1;
    }
}