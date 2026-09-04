class Solution 
{
    public int firstStableIndex(int[] nums, int k) 
    {
        int n = nums.length;
        int pre_min[] = new int[n];

        pre_min[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--)
            pre_min[i]=Math.min(pre_min[i+1],nums[i]);

        int max=nums[0];

        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);

            if(max-pre_min[i]<=k)
                return i;
        }
        
        return -1;
    }
}