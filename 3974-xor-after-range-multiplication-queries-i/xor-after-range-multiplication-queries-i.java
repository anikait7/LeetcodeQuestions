class Solution 
{
    public int xorAfterQueries(int[] nums, int[][] queries) 
    {
        for(int i=0;i<queries.length;i++)
        {
            long val=0;
            for(int j=queries[i][0];j<=queries[i][1];j+=queries[i][2])
            {
                val=1L*nums[j]*queries[i][3];
                nums[j]=(int)(val%1000000007);
            }
        }

        int xor=0;
        for(int i : nums)
            xor^=i;

        return xor;
    }
}