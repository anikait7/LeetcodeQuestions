class Solution 
{
    public int countValidSelections(int[] nums) 
    {
        int c=0;
        int sum=0;
        int left=0;
        
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                left+=nums[i];
                continue;
            }

            if(left==sum-left)
                c+=2;

            if(Math.abs(left*2-sum)==1)
                c+=1;
        }

        return c;
    }
}