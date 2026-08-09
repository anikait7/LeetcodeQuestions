class Solution 
{
    int MOD = 1000000007;
    int N;
    long dp[][];

    public long recursive(int a[][], int x, int y)
    {
        if(x==N)
            return 1;

        if(y==3)
        {
            int nums=0;
            for(int i=0;i<3;i++)
                nums=nums*10+a[x][i];

            if(dp[x][nums]!=-1)
                return dp[x][nums];

            return dp[x][nums] = recursive(a,x+1,0);
        }

        long sum=0;
        //up
        if(x-1>=0)
        {
            //left is possible
            if(y-1>=0)
            {
                for(int i=1;i<=3;i++)
                {
                    if(a[x-1][y]!=i && a[x][y-1]!=i)
                    {
                        a[x][y]=i;
                        sum+=recursive(a,x,y+1);
                        sum%=MOD;
                        a[x][y]=0;
                    }
                }
            }
            else
            {
                for(int i=1;i<=3;i++)
                {
                    if(a[x-1][y]!=i)
                    {
                        a[x][y]=i;
                        sum+=recursive(a,x,y+1);
                        sum%=MOD;
                        a[x][y]=0;
                    }
                }
            }
        }
        else
        {
            for(int i=1;i<=3;i++)
            {
                if(a[x][y-1]!=i)
                {
                    a[x][y]=i;
                    sum+=recursive(a,x,y+1);
                    sum%=MOD;
                    a[x][y]=0;
                }
            }
        }

        return sum;
    }

    public int numOfWays(int n) 
    {
        N=n;
        long sum=0;

        dp= new long[n][334];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        int a[][] = new int[n][3];

        for(int i=1;i<=3;i++)
        {
            a[0][0]=i;
            sum+=recursive(a,0,1);
            sum%=MOD;
        }

        return (int)(sum);
    }
}