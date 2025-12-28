class Solution 
{
    public long maximumScore(int[] nums) 
    {
        long max=Long.MIN_VALUE;
        int n = nums.length;

        int min[] = new int[n];
        min[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--)
            min[i]=Math.min(nums[i],min[i+1]);

        long leftsum=0;
        for(int i=0;i<n-1;i++)
        {
            leftsum+=nums[i];
            max=Math.max(max,leftsum-min[i+1]*1L);
        }

        return max;
    }
}