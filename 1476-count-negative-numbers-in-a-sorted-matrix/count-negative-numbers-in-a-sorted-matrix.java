class Solution 
{
    public int countNegatives(int[][] grid) 
    {
        int count=0;
        int r = grid.length;        int c = grid[0].length;
        int ub=c-1;

        for(int i=0;i<r;i++)
        {
            int lb=0;
            while(lb<=ub)
            {
                int mid = (lb+ub)/2;
                if(grid[i][mid]>=0)
                    lb=mid+1;
                else
                    ub=mid-1;
            }
            
            count+=c-lb;
        }

        return count;
    }
}