class Solution 
{
    public int largestMagicSquare(int[][] grid) 
    {
        int max=1;
        int m = grid.length;    int n = grid[0].length;

        int pre_row[][] = new int[m][n+1];
        int pre_col[][] = new int[m+1][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                pre_row[i][j+1]=pre_row[i][j]+grid[i][j];
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                pre_col[j+1][i] = pre_col[j][i]+grid[j][i];
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=max+1;i+k<=m && j+k<=n;k++)
                {
                    int ans = pre_row[i][j+k]-pre_row[i][j];
                    boolean flag=false;

                    //row change only
                    for(int x=i;x<i+k;x++)
                    {
                        if(pre_row[x][j+k]-pre_row[x][j]!=ans)
                        {
                            flag=true;
                            break;
                        }
                    }


                    //col change only
                    for(int x=j;x<j+k;x++)
                    {
                        if(pre_col[i+k][x]-pre_col[i][x]!=ans)
                        {
                            flag=true;
                            break;
                        }
                    }


                    //dia sum calc
                    int d1=0;   int d2=0;
                    for(int x=0;x<k;x++)
                    {
                        d1+=grid[i+x][j+x];
                        d2+=grid[i+x][j+k-1-x];
                    }

                    if(d1!=d2 || d1!=ans)
                        flag=true;

                    if(!flag)
                        max=k;
                }
            }
        }

        return max;
    }
}