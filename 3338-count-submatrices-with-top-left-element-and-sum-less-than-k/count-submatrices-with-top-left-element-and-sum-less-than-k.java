class Solution 
{
    public int countSubmatrices(int[][] grid, int k) 
    {
        int r = grid.length;    int c = grid[0].length;
        int pre_grid[][] = new int[r][c];

        int count=0;

        if(grid[0][0]>k)
            return 0;

        for(int i=0;i<r;i++)
        {
            boolean flag=true;
            for(int j=0;j<c;j++)
            {
                if(j==0)
                    pre_grid[i][j]=grid[i][j];
                else
                {
                    pre_grid[i][j]=pre_grid[i][j-1]+grid[i][j];
                    if(pre_grid[i][j]>k)
                        c=j;
                }
                
                if(i>0)
                {
                    pre_grid[i][j]=pre_grid[i-1][j]+grid[i][j]+(j==0 ? 0 : pre_grid[i][j-1]-pre_grid[i-1][j-1]);

                    if(pre_grid[i][j]>k)
                    {
                        flag=false;
                        count+=j;
                        break;
                    }
                }
            }

            if(flag)
                count+=c;
        }       

        return count;
    }
}