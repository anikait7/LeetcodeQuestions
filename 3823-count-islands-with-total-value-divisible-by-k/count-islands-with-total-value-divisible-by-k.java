class Solution 
{
    public int countIslands(int[][] grid, int k) 
    {
        int r = grid.length;
        int c = grid[0].length;

        boolean visited[][] = new boolean[r][c];
        int count=0;

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==0 || visited[i][j])
                    continue;
                else
                if(!visited[i][j] && grid[i][j]!=0)
                {
                    Queue<int[]> queue = new LinkedList<>();
                    long sum=grid[i][j]*1L;
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;

                    while(!queue.isEmpty())
                    {
                        int temp[] = queue.poll();
                        int x=temp[0];          int y=temp[1];

                        if(x-1>=0 && !visited[x-1][y] && grid[x-1][y]!=0)
                        {
                            queue.add(new int[]{x-1,y});
                            sum+=grid[x-1][y];
                            visited[x-1][y]=true;
                        }

                        if(x+1<r && !visited[x+1][y] && grid[x+1][y]!=0)
                        {
                            queue.add(new int[]{x+1,y});
                            sum+=grid[x+1][y];
                            visited[x+1][y]=true;
                        }

                        if(y-1>=0 && !visited[x][y-1] && grid[x][y-1]!=0)
                        {
                            queue.add(new int[]{x,y-1});
                            sum+=grid[x][y-1];
                            visited[x][y-1]=true;
                        }

                        if(y+1<c && !visited[x][y+1] && grid[x][y+1]!=0)
                        {
                            queue.add(new int[]{x,y+1});
                            sum+=grid[x][y+1];
                            visited[x][y+1]=true;
                        }
                    }
                    
                    if(sum%k==0)
                        count++;
                }
            }
        }

        return count;
    }
}