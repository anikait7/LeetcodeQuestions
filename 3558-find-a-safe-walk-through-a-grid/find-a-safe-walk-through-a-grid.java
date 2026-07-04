class Solution 
{
    public boolean findSafeWalk(List<List<Integer>> grid, int health) 
    {
        int r = grid.size();
        int c = grid.get(0).size();

        int visited[][] = new int[r][c];
        for(int visit[] : visited)
            Arrays.fill(visit,Integer.MAX_VALUE);

        PriorityQueue<int []> queue = new PriorityQueue<>((a,b) -> Integer.compare(b[2], a[2]));
        if(grid.get(0).get(0)==1)
            health--;

        queue.add(new int[]{0,0,health});

        while(!queue.isEmpty())
        {
            int temp[] = queue.poll();
            int x = temp[0];    int y = temp[1];

            if(temp[2]<=0)
                continue; 

            if(x==r-1 && y==c-1 && temp[2]>=1)
                return true;

            //left
            if(y-1>=0 && health<visited[x][y-1])
            {
                visited[x][y-1]=health;
                queue.add(new int[]{x,y-1,temp[2]-grid.get(x).get(y-1)});
            }
            //right
            if(y+1<c && health<visited[x][y+1])
            {
                visited[x][y+1]=health;
                queue.add(new int[]{x,y+1,temp[2]-grid.get(x).get(y+1)});
            }
            //up
            if(x-1>=0 && health<visited[x-1][y])
            {
                visited[x-1][y]=health;
                queue.add(new int[]{x-1,y,temp[2]-grid.get(x-1).get(y)});
            }
            //down
            if(x+1<r && health<visited[x+1][y])
            {
                visited[x+1][y]=health;
                queue.add(new int[]{x+1,y,temp[2]-grid.get(x+1).get(y)});
            }
        }

        return false;
    }
}