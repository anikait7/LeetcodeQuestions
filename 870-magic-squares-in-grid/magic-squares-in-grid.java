class Solution 
{
    public int numMagicSquaresInside(int[][] grid) 
    {
        int count=0;

        for(int i=0;i<=grid.length-3;i++)
        {
            for(int j=0;j<=grid[0].length-3;j++)
            {
                int r1 = grid[i][j]+grid[i][j+1]+grid[i][j+2];
                int r2 = grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
                int r3 = grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];

                int c1 = grid[i][j]+grid[i+1][j]+grid[i+2][j];
                int c2 = grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
                int c3 = grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
                
                int d1 = grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
                int d2 = grid[i+2][j]+grid[i+1][j+1]+grid[i][j+2];

                Set<Integer> set = new HashSet<>();
                
                set.add(r1);         set.add(r2);            set.add(r3);
                set.add(c1);         set.add(c2);            set.add(c3);
                set.add(d1);         set.add(d2);  

                if(set.size()!=1)
                    continue;

                Set<Integer> set1 = new HashSet<>();

                set1.add(grid[i][j]);     set1.add(grid[i][j+1]);       set1.add(grid[i][j+2]);
                set1.add(grid[i+1][j]);     set1.add(grid[i+1][j+1]);       set1.add(grid[i+1][j+2]);
                set1.add(grid[i+2][j]);     set1.add(grid[i+2][j+1]);       set1.add(grid[i+2][j+2]);

                if(set1.size()==9 && !set1.contains(0) && !set1.contains(10) && !set1.contains(11) && !set1.contains(12) && 
                                        !set1.contains(13) && !set1.contains(14) && !set1.contains(15))
                                            count++;
            }          
        }

        return count;
    }
}