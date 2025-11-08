class Solution 
{
    public int countMajoritySubarrays(int[] nums, int target) 
    {
        int c=0;
        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            int freq=0;
            for(int j=i;j<n;j++)
            {
                if(nums[j]==target)
                    freq++;

                if(freq>(j-i+1)/2)
                    c++;
            }
        }

        return c;
    }
}