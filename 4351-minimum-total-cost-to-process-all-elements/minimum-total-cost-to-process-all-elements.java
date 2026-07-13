class Solution 
{
    public int minimumCost(int[] nums, int k) 
    {
        int MOD = 1000000007;

        int copy=k;
        long operations=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<=k)
                k-=nums[i];
            else
            {   
                int temp = (nums[i]-k-1)/copy+1;
                operations+=temp;
                k=copy*temp-nums[i]+k;
            }

            System.out.println(operations);
        }

        operations%=MOD;
        return (int)((operations*(operations+1)/2)%MOD);
    }
}