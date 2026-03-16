class Solution 
{
    public int[] getBiggestThree(int[][] grid) 
    {
        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());

        int r = grid.length;    int c = grid[0].length;
        int pre_sum_left[][] = new int[r][c];  //top right to bottom left
        int pre_sum_right[][] = new int[r][c]; //top left to bottom right

        for(int i=0;i<c;i++)
        {
            int x1=0;    int y1=i;
            int sum1=0; 

            while(x1<r && y1<c)
            {
                sum1+=grid[x1][y1];
                pre_sum_right[x1++][y1++]=sum1;
            }

            int x2=0;    int y2=i;
            int sum2=0;

            while(x2<r && y2>=0)
            {
                sum2+=grid[x2][y2];
                pre_sum_left[x2++][y2--]=sum2;
            }
        }

        for(int i=1;i<r;i++)
        {
            int x1=i;    int y1=0;
            int sum1=0; 

            while(x1<r && y1<c)
            {
                sum1+=grid[x1][y1];
                pre_sum_right[x1++][y1++]=sum1;
            }

            int x2=i;    int y2=c-1;
            int sum2=0;

            while(x2<r && y2>=0)
            {
                sum2+=grid[x2][y2];
                pre_sum_left[x2++][y2--]=sum2;
            }
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                for(int k=0;k<=(Math.min(r,c))/2;k++)
                {
                    if(k==0)
                    {
                        tree.add(grid[i][j]);
                        continue;
                    }

                    int x = i;  int y = j;

                    if(x+k*2<r && y-k>=0 && y+k<c)
                    {
                        int sub=0;  int sum=0;

                        if(x-1>=0)
                            sub=pre_sum_left[x-1][y+1];
                        else
                            sub=0;

                        sum+=pre_sum_left[x+k][y-k]-sub;

                        if(y+k+1<c && x-1+k<r)
                            sub=pre_sum_left[x+k-1][y+1+k];
                        else
                            sub=0;

                        sum+=pre_sum_left[x+k*2][y]-sub;

                        if(x-1>=0)
                            sub=pre_sum_right[x-1][y-1];
                        else
                            sub=0;

                        sum+=pre_sum_right[x+k][y+k]-sub;

                        if(y-k-1>=0)
                            sub=pre_sum_right[x+k-1][y-k-1];
                        else
                            sub=0;

                        sum+=pre_sum_right[x+k*2][y]-sub;

                        sum=sum-grid[x][y]-grid[x+2*k][y]-grid[x+k][y-k]-grid[x+k][y+k];
                        tree.add(sum);                        
                    }
                    else
                        break;
                }

                while(tree.size()>3)
                    tree.pollLast();
            }
        }
        
        int arr[] = new int[tree.size()];
        int count=0;
        while(!tree.isEmpty())
        {
            arr[count++]=tree.pollFirst();
        }

        return arr;
    }
}