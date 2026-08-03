class Solution 
{
    int pre_sum[];
    int dp[][][];
    int sum=0;

    public int recursive(int index, int piles[], int M, int turn)
    {
        //1 -> Alice turn
        //2 -> Bob turn

        if(index>=piles.length)
            return 0;

        if(dp[index][M][turn]!=-1)
            return dp[index][M][turn];

        int stones=0;
        int result;

        if(turn==1)
        {
            result=-1;

            for(int i=1;i<=Math.min(2*M,piles.length-index);i++)
            {
                stones=pre_sum[index+i]-pre_sum[index];
                result=Math.max(result,stones+recursive(index+i,piles,Math.max(M,i),2));
            }
        }
        else
        {
            result=Integer.MAX_VALUE;

            for(int i=1;i<=Math.min(2*M,piles.length-index);i++)
            {
                result=Math.min(result,recursive(index+i,piles,Math.max(M,i),1));
            }            
        }

        return dp[index][M][turn]=result;
    }

    public int stoneGameII(int[] piles) 
    {
        int M=1;   
        int len = piles.length;

        dp = new int[len][len+1][3];

        for(int i=0;i<len;i++)
            for(int j=0;j<=len;j++)
                Arrays.fill(dp[i][j],-1);

        //Alice will choose the maximum and Bob will try to make things difficult for Alice by choosing value that leads to minimum pick of Alice. This is the optimization

        pre_sum = new int[len+1];

        for(int i=0;i<len;i++)
            pre_sum[i+1]=pre_sum[i]+piles[i];

        return recursive(0,piles,M,1);

        // return sum;
    }
}