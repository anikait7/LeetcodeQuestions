class Solution 
{
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) 
    {
        int c=1;

        for(int i=x;i<x+k/2;i++)
        {
            for(int j=y;j<y+k;j++)
            {
                int temp = grid[i][j]^grid[x+k-c][j];
                grid[i][j]^=temp;
                grid[x+k-c][j]^=temp;
            }
            c++;
        }

        return grid;
    }
}