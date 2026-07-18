class Solution 
{
    public int findGCD(int[] nums) 
    {
        int high=nums[0];
        int low = nums[0];

        for(int i : nums)
        {
            high=Math.max(high,i);
            low=Math.min(low,i);
        }

        while(high%low!=0)
        {
            int mod = high%low;
            high=low;
            low=mod;
        }

        return low;
    }
}