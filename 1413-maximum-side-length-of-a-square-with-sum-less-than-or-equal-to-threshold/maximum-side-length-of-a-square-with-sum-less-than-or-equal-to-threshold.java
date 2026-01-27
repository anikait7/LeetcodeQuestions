class Solution 
{
    public int maxSideLength(int[][] mat, int threshold) 
    {
        int r = mat.length;     int c = mat[0].length;
        
        //row prefix sum
        int col_sum[][] = new int[r+1][c+1];

        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=c;j++)
            {
                col_sum[i][j]=col_sum[i-1][j]+col_sum[i][j-1]-col_sum[i-1][j-1]+mat[i-1][j-1];
            }
        }

        int size=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int lb=0;
                int ub = Math.min(r-i,c-j);

                while(lb<=ub)
                {
                    int mid = (lb+ub)/2;
                    int val = col_sum[i+mid][j+mid]-col_sum[i][j+mid]-col_sum[i+mid][j]+col_sum[i][j];

                    if(val<=threshold)
                        lb=mid+1;
                    else
                        ub=mid-1;
                }

                size = Math.max(size,ub);
            }
        }


        return size;
    }
}