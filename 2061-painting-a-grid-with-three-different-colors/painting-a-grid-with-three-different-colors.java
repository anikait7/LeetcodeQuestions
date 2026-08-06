class Solution 
{
    int M;      int N;
    int MOD = 1000000007;
    int dp[][];

    //red = 1, blue = 2, green = 3

    public int recursive(int x, int y, int arr[][])
    {
        int sum=0;

        if(x==M)
        {
            int temp=0;
            for(int i=0;i<M;i++)
                temp=temp*10+arr[i][y];

            if(dp[temp][y]!=0)
                return dp[temp][y];

            return dp[temp][y] = recursive(0,y+1,arr);
        }

        if(y==N)
            return 1;

        //3 case -> only top, only left, top and left

        //checking top and it exists
        if(x-1>=0)
        {
            int color_x = arr[x-1][y];

            //checking left and it exists
            if(y-1>=0)
            {
                int color_y = arr[x][y-1];

                for(int i=1;i<=3;i++)
                {
                    if(color_x!=i && color_y!=i)
                    {
                        arr[x][y]=i;
                        sum+=recursive(x+1,y,arr);
                        sum%=MOD;
                        arr[x][y]=0;
                    }
                }
            }
            else //checking left and it doesnt exist
            {
                for(int i=1;i<=3;i++)
                {
                    if(color_x!=i)
                    {
                        arr[x][y]=i;
                        sum+=recursive(x+1,y,arr);
                        sum%=MOD;
                        arr[x][y]=0;
                    }
                }
            }
        }
        else //checking top and it doesnt exist
        {
            //checking left and it exists
            int color_y=arr[x][y-1];

            for(int i=1;i<=3;i++)
            {
                if(color_y!=i)
                {
                    arr[x][y]=i;
                    sum+=recursive(x+1,y,arr);
                    sum%=MOD;
                    arr[x][y]=0;
                }
            }
            
            //checking left and it doesnt exist: NO CASE WILL COME LIKE THIS            
        }

        return sum;
    }

    public int colorTheGrid(int m, int n) 
    {
        M=m;    N=n;

        //my dp memoization table should contain previous column and index previous column is 5 with max value 33333
        dp = new int[33334][n+1];

        int arr[][] = new int[m][n];
        int sum=0;

        for(int i=1;i<=3;i++)
        {
            arr[0][0]=i;
            sum+=recursive(1,0,arr);
            sum%=MOD;
        }

        return sum;
    }
}