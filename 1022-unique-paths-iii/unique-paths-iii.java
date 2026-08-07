class Solution 
{
    int count=0;

    public void recursive(int grid[][], int x, int y, int steps[][])
    {
        if(x>=grid.length || y>=grid[0].length || x<0 || y<0 || steps[x][y]==1)
            return ;

        if(grid[x][y]==2)
        {
            boolean flag=true;
            steps[x][y]=1;

            for(int i=0;i<steps.length;i++)
            {
                for(int j=0;j<steps[0].length;j++)
                {
                    if(steps[i][j]==0)
                    {
                        flag=false;
                        i=30;   j=40;
                    }
                }
            }

            steps[x][y]=2;

            if(flag)
                count++;

            return ;
        }

        steps[x][y]=1;

        //go left
        recursive(grid,x,y-1,steps);

        //go right
        recursive(grid,x,y+1,steps);

        //go up
        recursive(grid,x-1,y,steps);

        //go down
        recursive(grid,x+1,y,steps);

        steps[x][y]=0;
    }

    public int uniquePathsIII(int[][] grid) 
    {
        int x=0;    int y=0;

        int steps[][] = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    x=i;    y=j;
                }

                if(grid[i][j]==-1)
                    steps[i][j]=1;
            }
        }
    
        recursive(grid,x,y,steps);

        return count;
    }
}