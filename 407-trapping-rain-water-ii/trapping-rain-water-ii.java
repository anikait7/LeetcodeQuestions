import java.util.*;
class Solution 
{
    public int trapRainWater(int[][] heightMap) 
    {
        int row=heightMap.length;
        int col=heightMap[0].length;

        int r,c,val;        int sum=0;

        if(row<3 || col<3)
            return 0;

        boolean visited[][] = new boolean[row][col];
        PriorityQueue<int []> minheap = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<col;i++)
        {
            minheap.offer(new int[]{heightMap[0][i],0,i});
            minheap.offer(new int[]{heightMap[row-1][i],row-1,i});
            visited[0][i]=true;        visited[row-1][i]=true;
        }

        for(int i=1;i<row-1;i++)
        {
            minheap.offer(new int[]{heightMap[i][0],i,0});
            minheap.offer(new int[]{heightMap[i][col-1],i,col-1});
            visited[i][0]=true;        visited[i][col-1]=true;
        }

        int temp[] = new int[3];
        while(!minheap.isEmpty())
        {
            temp=minheap.poll();
            val=temp[0];    r=temp[1];    c=temp[2];
            int val1;
            
            if(r-1>=0 && !visited[r-1][c])
            {
                visited[r-1][c]=true;
                val1=heightMap[r-1][c];
                if(val1>val)
                    minheap.offer(new int[]{heightMap[r-1][c],r-1,c});
                else
                {
                    sum+=val-val1;
                    minheap.offer(new int[]{val,r-1,c});
                }
            }

            if(r+1<row && !visited[r+1][c])
            {
                visited[r+1][c]=true;
                val1=heightMap[r+1][c];
                if(val1>val)
                    minheap.offer(new int[]{heightMap[r+1][c],r+1,c});
                else
                {
                    sum+=val-val1;
                    minheap.offer(new int[]{val,r+1,c});
                }
            }

            if(c-1>=0 && !visited[r][c-1])
            {
                visited[r][c-1]=true;
                val1=heightMap[r][c-1];
                if(val1>val)
                    minheap.offer(new int[]{heightMap[r][c-1],r,c-1});
                else
                {
                    sum+=val-val1;
                    minheap.offer(new int[]{val,r,c-1});
                }
            }

            if(c+1<col && !visited[r][c+1])
            {
                visited[r][c+1]=true;
                val1=heightMap[r][c+1];
                if(val1>val)
                    minheap.offer(new int[]{heightMap[r][c+1],r,c+1});
                else
                {
                    sum+=val-val1;
                    minheap.offer(new int[]{val,r,c+1});
                }
            }            
        }

        return sum;
    }
}