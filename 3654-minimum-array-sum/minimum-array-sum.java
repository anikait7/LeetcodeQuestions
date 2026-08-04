class Solution 
{
    int dp[][][];

    public int recursive(int[] nums, int k, int op1, int op2, int index)
    {
        int min=Integer.MAX_VALUE;

        if(index==nums.length)        
            return 0;        

        if(dp[op1][op2][index]!=-1)
            return dp[op1][op2][index];

        //op1
        if(op1>0)
        {
            min=(nums[index]+1)/2+recursive(nums,k,op1-1,op2,index+1);
        }

        //op2
        if(op2>0 && nums[index]>=k)
        {
            min=Math.min(min,nums[index]-k+recursive(nums,k,op1,op2-1,index+1));
        }

        if(op1>0 && op2>0)
        {
            int temp = nums[index];

            //op1 then op2
            int temp1 = (temp+1)/2;
            if(temp1>=k)
                min=Math.min(min,temp1-k+recursive(nums,k,op1-1,op2-1,index+1));

            //op2 then op1
            if(temp>=k)
            {
                temp-=k;
                temp=(temp+1)/2;
                min=Math.min(min,temp+recursive(nums,k,op1-1,op2-1,index+1));
            }
        }

        //do nothing
        min=Math.min(min,nums[index]+recursive(nums,k,op1,op2,index+1));

        return dp[op1][op2][index]=min;
    }

    public int minArraySum(int[] nums, int k, int op1, int op2) 
    {
        dp = new int[op1+1][op2+1][nums.length+1];

        for(int i=0;i<=op1;i++)
            for(int j=0;j<=op2;j++)
                Arrays.fill(dp[i][j],-1);

        return recursive(nums,k,op1,op2,0);
    }
}