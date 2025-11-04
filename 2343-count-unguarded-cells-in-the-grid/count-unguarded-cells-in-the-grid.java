class Solution 
{
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) 
    {
        int grid[][] = new int[m][n];

        //1 for guards 2 for walls

        for(int a[] : walls)
        {
            grid[a[0]][a[1]]=2;
        }

        for(int a[] : guards)
        {
            grid[a[0]][a[1]]=1;
        }

        for(int a[] : guards)
        {
            int x = a[0];   int y = a[1];            

            for(int i=y-1;i>=0;i--)
            {
                if(grid[x][i]==2 || grid[x][i]==1)
                    break;
                grid[x][i]=-1;
            }

            for(int i=y+1;i<n;i++)
            {
                if(grid[x][i]==2 || grid[x][i]==1)
                    break;
                grid[x][i]=-1;
            }

            for(int i=x-1;i>=0;i--)
            {
                if(grid[i][y]==2 || grid[i][y]==1)
                    break;
                grid[i][y]=-1;
            }

            for(int i=x+1;i<m;i++)
            {
                if(grid[i][y]==2 || grid[i][y]==1)
                    break;
                grid[i][y]=-1;
            }
        }

        int c=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==0)
                    c++;
        
        return c;
    }
}