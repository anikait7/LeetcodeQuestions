class Solution 
{
    public int minimumPrefixLength(int[] nums) 
    {
        int n = nums.length;
        int ptr1=n+1;
        int last=nums[n-1];

        for(int i=n-2;i>=0;i--)
        {
            if(last>nums[i])
            {
                last=nums[i];
                continue;
            }
            else
            {
                ptr1=i;
                break;
            }
        }

        if(ptr1==n+1)
            return 0;

        return ptr1+1;
    }
}