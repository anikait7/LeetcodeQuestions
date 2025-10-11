class Solution 
{
    public int longestSubarray(int[] nums) 
    {
        int max=2;
        int c=2;
        int left=0;

        for(int i=2;i<nums.length;i++)
        {
            if(nums[left]+nums[left+1]==nums[i])
                c++;
            else
            {
                max=Math.max(max,c);
                c=2;
            }

            left++;
        }

        return Math.max(max,c);
    }
}