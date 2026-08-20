class Solution 
{
    int pre_sum[];
    int n;
    int dp[][];

    public int recursive(int lb, int ub, int arr[])
    {
        if(lb==ub)
            return 0;

        int max=0;

        if(dp[lb][ub]!=-1)
            return dp[lb][ub];

        for(int i=lb+1;i<=ub;i++)
        {
            int left = pre_sum[i]-pre_sum[lb];
            int right = pre_sum[ub+1]-pre_sum[i];

            if(left==right)
            {
                int max1=Math.max(recursive(lb,i-1,arr),recursive(i,ub,arr));
                max=Math.max(max,left+max1);
            }
            else
            if(left>right)
            {
                max=Math.max(max,right+recursive(i,ub,arr));
            }
            else
            {
                max=Math.max(max,left+recursive(lb,i-1,arr));
            }
        }

        return dp[lb][ub]=max;
    }

    public int stoneGameV(int[] stoneValue) 
    {
        n = stoneValue.length;
        pre_sum = new int[n+1];

        //memoization
        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);

        //prefix sum
        for(int i=0;i<n;i++)
            pre_sum[i+1]=pre_sum[i]+stoneValue[i];
        
        return recursive(0,n-1,stoneValue);
    }
}