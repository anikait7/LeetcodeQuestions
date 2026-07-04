class Solution 
{
    public int findMax(Set<int []> set, int x, int y)
    {
        int max=Integer.MAX_VALUE;

        for(int arr[] : set)
            max=Math.min(max,Math.abs(arr[0]-x)+Math.abs(arr[1]-y));

        return max;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) 
    {
        Set<int []> set = new HashSet<>();
        int max=0; //final answer

        int r = grid.size();
        int c = grid.get(0).size();
        int calc=Integer.MAX_VALUE; //temporary max value

        if(grid.get(0).get(0)==1 || grid.get(r-1).get(c-1)==1)
            return 0;

        boolean visited[][] = new boolean[r][c];

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid.get(i).get(j)==1)
                {
                    set.add(new int[]{i,j});
                    calc=Math.min(calc,i+j);
                    visited[i][j]=true;
                }
            }
        }

        System.out.print(calc);
        //row + col + compute max
        PriorityQueue<int []> queue = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        queue.add(new int[]{0,0,calc});

        while(!queue.isEmpty())
        {
            int temp[] = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int val = temp[2];

            if(x==r-1 && y==c-1)
            {
                max=Math.max(max,val);
                continue;
            }

            //left
            if(y-1>=0 && !visited[x][y-1])
            {
                calc=findMax(set,x,y-1);
                visited[x][y-1]=true;
                queue.add(new int[]{x,y-1,Math.min(val,calc)});
            }
            //right
            if(y+1<c && !visited[x][y+1])
            {
                calc=findMax(set,x,y+1);
                visited[x][y+1]=true;
                queue.add(new int[]{x,y+1,Math.min(val,calc)});
            }
            //up
            if(x-1>=0 && !visited[x-1][y])
            {
                calc=findMax(set,x-1,y);
                visited[x-1][y]=true;
                queue.add(new int[]{x-1,y,Math.min(val,calc)});
            }
            //down
            if(x+1<r && !visited[x+1][y])
            {
                calc=findMax(set,x+1,y);
                visited[x+1][y]=true;
                queue.add(new int[]{x+1,y,Math.min(val,calc)});
            }
        }

        return max;
    }
}