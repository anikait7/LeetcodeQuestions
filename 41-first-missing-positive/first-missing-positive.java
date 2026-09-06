class Solution 
{
    public int firstMissingPositive(int[] nums) 
    {
        int n = nums.length;

        //convert everything to positive
        for(int i=0;i<n;i++)
        {
            if(nums[i]<=0 || nums[i]>n)
                nums[i]=n+1;
        }

        for(int i=0;i<n;i++)
        {
            int x = Math.abs(nums[i]);

            if(x<=n)
                nums[x-1] = -Math.abs(nums[x-1]);
        }

        for(int i=0;i<n;i++)
            if(nums[i]>0)
                return i+1;

        return n+1;
    }
}