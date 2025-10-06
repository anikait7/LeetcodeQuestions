class Solution 
{
    public int swimInWater(int[][] grid) 
    {
        int n = grid.length;
        int lb=grid[0][0];      int ub=n*n-1;

        while(lb<=ub)
        {
            int mid = (lb+ub)/2;

            Queue<int[]> pq = new LinkedList<>();
            boolean visited[][] = new boolean[n][n];
            boolean flag=false;

            pq.add(new int[]{0,0});
            visited[0][0]=true;

            while(!pq.isEmpty())
            {
                int temp[] = pq.poll();
                int x = temp[0];    int y = temp[1];

                if(x==n-1 && y==n-1)
                {
                    flag=true;
                    break;
                }

                if(x-1>=0 && !visited[x-1][y] && grid[x-1][y]<=mid)
                {
                    visited[x-1][y]=true;
                    pq.add(new int[]{x-1,y});
                }

                if(y-1>=0 && !visited[x][y-1] && grid[x][y-1]<=mid)
                {
                    visited[x][y-1]=true;
                    pq.add(new int[]{x,y-1});
                }

                if(x+1<n && !visited[x+1][y] && grid[x+1][y]<=mid)
                {
                    visited[x+1][y]=true;
                    pq.add(new int[]{x+1,y});
                }

                if(y+1<n && !visited[x][y+1] && grid[x][y+1]<=mid)
                {
                    visited[x][y+1]=true;
                    pq.add(new int[]{x,y+1});
                }
            }

            if(flag)
                ub=mid-1;
            else
                lb=mid+1;
        }

        return lb;
    }
}