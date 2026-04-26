class Solution 
{
    public boolean containsCycle(char[][] grid) 
    {
        int r = grid.length;
        int c = grid[0].length;
        boolean visited[][] = new boolean[r][c];

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(!visited[i][j])
                {
                    Stack<int []> stack = new Stack<>();
                    //curr_x,curr_y,parent_x,parent_y

                    stack.push(new int[]{i,j,-1,-1});

                    while(!stack.isEmpty())
                    {
                        int temp[] = stack.pop();
                        int x = temp[0];    int y = temp[1];
                        visited[x][y]=true;
                        int p_x = temp[2];    int p_y = temp[3];

                        if(x+1<r && grid[x][y]==grid[x+1][y])
                        {
                            if(visited[x+1][y] && !(x+1==p_x && y==p_y))
                                return true;

                            if(!visited[x+1][y])
                                stack.push(new int[]{x+1,y,x,y});
                        }

                        if(x-1>=0 && grid[x][y]==grid[x-1][y])
                        {
                            if(visited[x-1][y] && !(x-1==p_x && y==p_y))
                                return true;

                            if(!visited[x-1][y])
                                stack.push(new int[]{x-1,y,x,y});
                        }

                        if(y+1<c && grid[x][y]==grid[x][y+1])
                        {
                            if(visited[x][y+1] && !(x==p_x && y+1==p_y))
                                return true;

                            if(!visited[x][y+1])
                                stack.push(new int[]{x,y+1,x,y});
                        }

                        if(y-1>=0 && grid[x][y]==grid[x][y-1])
                        {
                            if(visited[x][y-1] && !(x==p_x && y-1==p_y))
                                return true;

                            if(!visited[x][y-1])
                                stack.push(new int[]{x,y-1,x,y});
                        }
                    }
                }
            }
        }

        return false;
    }
}