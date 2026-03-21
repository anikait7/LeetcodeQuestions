class Solution 
{
    public long recursive(int zero, int one, int limit, int prev, long dp[][][], boolean visited[][][])
    {
        if(zero==0 && one==0)
            return 1L;

        if(prev==0)// for 1 filling
        {
            if(visited[prev][zero][one])
                return dp[prev][zero][one];

            for(int i=1;i<=Math.min(one,limit);i++)
            {
                dp[0][zero][one]+=recursive(zero,one-i,limit,1,dp,visited);
                visited[prev][zero][one]=true;
            }
        }
        else
        if(prev==1)// for 0 filling
        {
            if(visited[prev][zero][one])
                return dp[prev][zero][one];

            for(int i=1;i<=Math.min(zero,limit);i++)
            {
                dp[1][zero][one]+=recursive(zero-i,one,limit,0,dp,visited);
                visited[prev][zero][one]=true;
            }
        }

        return dp[prev][zero][one]%=1000000007;
    }

    public int numberOfStableArrays(int zero, int one, int limit) 
    {
        long dp[][][] = new long[2][zero+1][one+1];
        boolean visited[][][] = new boolean[2][zero+1][one+1];

        //2 -> means prev = 0 or 1
        //zero -> no. of zeros left
        //one -> no. of ones left

        //less than limit ones/zeros can come together 

        

        return (int)(recursive(zero,one,limit,0,dp,visited) + recursive(zero,one,limit,1,dp,visited))%1000000007;
    }
}