class Solution 
{
    public int numberOfSubmatrices(char[][] grid) 
    {
        int r = grid.length;       int c = grid[0].length;
        int pre_sum[][] = new int[r][c];
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='.')
                    pre_sum[i][j]=0;
                else
                if(grid[i][j]=='X')
                    pre_sum[i][j]=1;
                else
                    pre_sum[i][j]=-1;

                if(j>0)
                    pre_sum[i][j]+=pre_sum[i][j-1];

                if(i>0)
                    pre_sum[i][j]+=pre_sum[i-1][j]+(j==0? 0 : -pre_sum[i-1][j-1]);                
            }
        }

        int count=0;

        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                if(pre_sum[i][j]==0)
                    count++;
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='.')
                    count--;
                else
                    c=j;
            }
        }

        return count;
    }
}