class Solution 
{
    int dp[];

    public int recursive(int sum[], int index)
    {
        if(index>=sum.length-1)
            return sum[sum.length-1];        

        if(dp[index]!=Integer.MIN_VALUE)
            return dp[index];

        //take
        int temp1 = sum[index]-recursive(sum,index+1);

        //skip
        int temp2 = recursive(sum,index+1);


       return dp[index]=Math.max(temp1,temp2);
    }

    public int stoneGameVIII(int[] stones) 
    {
        int n = stones.length;
        dp = new int[n];

        Arrays.fill(dp,Integer.MIN_VALUE);

        int pre_sum[] = new int[n];
        pre_sum[0]=stones[0];

        for(int i=1;i<n;i++)
            pre_sum[i]=pre_sum[i-1]+stones[i];

        return recursive(pre_sum,1);
    }
}