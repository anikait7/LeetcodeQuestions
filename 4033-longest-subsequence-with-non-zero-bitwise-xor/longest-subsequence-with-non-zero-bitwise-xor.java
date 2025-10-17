class Solution
{
    public int longestSubsequence(int[] nums)
    {
        int xor=0;
        long sum=0;

        for(int i : nums)
        {
            sum+=i;
            xor^=i;
        }

        if(sum==0)
            return 0;

        if(xor!=0)
            return nums.length;
        else
            return nums.length-1;
    }
}