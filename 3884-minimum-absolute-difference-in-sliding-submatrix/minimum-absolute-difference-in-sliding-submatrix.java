class Solution 
{
    public int[][] minAbsDiff(int[][] grid, int k) 
    {
        int m=grid.length;
        int n=grid[0].length;

        int ans[][] = new int[m-k+1][n-k+1];

        for(int i=0;i<m-k+1;i++)
        {
            for(int j=0;j<n-k+1;j++)
            {
                int temp[] = new int[k*k];
                int c=0;
                for(int x=i;x<i+k;x++)
                {
                    for(int y=j;y<j+k;y++)
                    {
                        temp[c++]=grid[x][y];
                    }
                }
            
                Arrays.sort(temp);
                if(temp.length==1)
                    continue;
                

                int abs;
                if(temp[0]==temp[c-1])
                    abs=0;
                else
                    abs=Integer.MAX_VALUE;

                for(int x=1;x<temp.length;x++)
                {
                    if(temp[x]!=temp[x-1])
                        abs=Math.min(abs,temp[x]-temp[x-1]);
                }

                ans[i][j]=abs;
            }
        }

        return ans;
    }
}