class Solution 
{
    public int sortPermutation(int[] nums) 
    {
        int val=-1;
        int n = nums.length;

        for(int i=0;i<nums.length;i++)
        {
            if(i!=nums[i])
            {
                if(val==-1)
                    val=nums[i];
                else
                    val=val&nums[i];
            }
        }

        if(val==-1) //already sorted
            return 0;

        return val;
    }
}