class Solution 
{
    public int countPartitions(int[] nums) 
    {
        int count=0;
        int sum=0;
        int sum1=0;

        for(int i=0;i<nums.length;i++)
            sum+=nums[i];

        for(int i=0;i<nums.length-1;i++)
        {
            sum1+=nums[i];
            sum-=nums[i];

            if((sum1-sum)%2==0)
                count++;
        }
        
        return count;
    }
}