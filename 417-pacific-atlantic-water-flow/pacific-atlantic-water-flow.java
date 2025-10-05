class Solution 
{
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        Set<List<Integer>> ans = new HashSet<>();
        int r = heights.length;
        int c = heights[0].length;

        Queue<int []> queue = new LinkedList<>();
        Set<List<Integer>> pacific = new HashSet<>();
        boolean visited[][] = new boolean[r][c];

        for(int i=0;i<r;i++)
        {
            queue.add(new int[]{i,0});
            pacific.add(Arrays.asList(i,0));
            visited[i][0]=true;
        }

        for(int i=0;i<c;i++)
        {
            queue.add(new int[]{0,i});
            pacific.add(Arrays.asList(0,i));
            visited[0][i]=true;
        }

        while(!queue.isEmpty())
        {
            int temp[] = queue.poll();
            int x = temp[0];    int y = temp[1];

            if(x-1>=0 && !visited[x-1][y] && heights[x-1][y]>=heights[x][y])
            {
                queue.add(new int[]{x-1,y});
                pacific.add(Arrays.asList(x-1,y));
                visited[x-1][y]=true;
            }

            if(y+1<c && !visited[x][y+1] && heights[x][y+1]>=heights[x][y])
            {
                queue.add(new int[]{x,y+1});
                pacific.add(Arrays.asList(x,y+1));
                visited[x][y+1]=true;
            }

            if(y-1>=0 && !visited[x][y-1] && heights[x][y-1]>=heights[x][y])
            {
                queue.add(new int[]{x,y-1});
                pacific.add(Arrays.asList(x,y-1));
                visited[x][y-1]=true;
            }

            if(x+1<r && !visited[x+1][y] && heights[x+1][y]>=heights[x][y])
            {
                queue.add(new int[]{x+1,y});
                pacific.add(Arrays.asList(x+1,y));
                visited[x+1][y]=true;
            }
        }

        queue = new LinkedList<>();
        visited = new boolean[r][c];

        for(int i=0;i<r;i++)
        {
            queue.add(new int[]{i,c-1});
            visited[i][c-1]=true;
        }

        for(int i=0;i<c;i++)
        {
            queue.add(new int[]{r-1,i});
            visited[r-1][i]=true;
        }

        while(!queue.isEmpty())
        {
            int temp[] = queue.poll();
            int x = temp[0];    int y = temp[1];

            if(pacific.contains(Arrays.asList(x,y)))
                ans.add(Arrays.asList(x,y));

            if(x-1>=0 && !visited[x-1][y] && heights[x-1][y]>=heights[x][y])
            {
                queue.add(new int[]{x-1,y});
                visited[x-1][y]=true;
            }

            if(y+1<c && !visited[x][y+1] && heights[x][y+1]>=heights[x][y])
            {
                queue.add(new int[]{x,y+1});
                visited[x][y+1]=true;
            }

            if(y-1>=0 && !visited[x][y-1] && heights[x][y-1]>=heights[x][y])
            {
                queue.add(new int[]{x,y-1});
                visited[x][y-1]=true;
            }

            if(x+1<r && !visited[x+1][y] && heights[x+1][y]>=heights[x][y])
            {
                queue.add(new int[]{x+1,y});
                visited[x+1][y]=true;
            }
        }        

        List<List<Integer>> ocean = new ArrayList<>(ans);
        return ocean;
    }
}