class Solution 
{
    public int countSubmatrices(int[][] grid, int k) 
    {
        int r = grid.length;    int c = grid[0].length;
        int pre_grid[][] = new int[r][c];

        int count=0;
        Map<Integer,Integer> map = new HashMap<>();

        if(grid[0][0]>k)
            return 0;

        for(int i=0;i<r;i++)
        {
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
                        map.put(i,j);
                        break;
                    }
                }
            }

            if(!map.containsKey(i))
                map.put(i,c);
        }

        int i=0;
        while(map.containsKey(i))
            count+=map.get(i++);        

        return count;
    }
}