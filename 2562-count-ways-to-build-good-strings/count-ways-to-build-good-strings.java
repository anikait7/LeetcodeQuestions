class Solution 
{
    int MOD = 1000000007;
    int dp[];

    public int recursive(int low, int high, int zero, int one, int count)
    {
        long sum=0;

        if(count>high)
            return 0;

        if(count==high)
            return 1;

        if(dp[count]!=-1)
            return dp[count];

        if(count<low)
        {
            //no of zeros coming together
            sum+=recursive(low,high,zero,one,count+zero);           sum%=MOD;

            //no of one coming together
            sum+=recursive(low,high,zero,one,count+one);            sum%=MOD;
        }
        else
        {
            //no of zeros coming together                    //no of one coming together
            sum+=1+recursive(low,high,zero,one,count+zero) + recursive(low,high,zero,one,count+one);    
            sum%=MOD;     
        }

        return dp[count]=(int)sum;
    }

    public int countGoodStrings(int low, int high, int zero, int one) 
    {    
        dp = new int[high+1];
        Arrays.fill(dp,-1);

        return recursive(low,high,zero,one,0);
    }
}
/*
    count=1,
             count=2
*/