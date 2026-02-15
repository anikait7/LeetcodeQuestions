class Solution 
{
    long mem[];

    public long dp(int[] nums, int lb, int ub)
    {
        if(lb>=ub)
            return 0L;

        if(mem[lb]!=0)
            return mem[lb];

        return mem[lb]=Math.max(nums[lb]+dp(nums,lb+2,ub),dp(nums,lb+1,ub));
    }

    public long rob(int[] nums, int[] colors) 
    {
        long sum=0;
        mem = new long[colors.length];

        for(int i=0;i<nums.length;)
        {
            int count=i+1;
            int max=nums[i];
            while(count<nums.length)
            {
                if(colors[count]==colors[i])
                    count++;
                else
                    break;
            }

            sum+=dp(nums, i, count);
            i=count;
        }

        return sum;
    }
}