class Solution 
{
    public long maxTotalValue(int[] nums, int k) 
    {
        int min=nums[0];
        int max=nums[0];

        for(int i : nums)
        {
            max=Math.max(max,i);
            min=Math.min(min,i);
        }

        return (max-min)*1L*k;
    }
}