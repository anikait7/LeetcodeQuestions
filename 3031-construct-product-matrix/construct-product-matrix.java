class Solution 
{
    public int[][] constructProductMatrix(int[][] grid) 
    {
        int r = grid.length;    int c = grid[0].length;
        long arr[] = new long[r*c+1];

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
                arr[i*c+j]=grid[i][j]%12345;
        }

        int pre_pro[] = new int[r*c+1];
        pre_pro[r*c]=1;

        for(int i=r*c-1;i>=0;i--)
            pre_pro[i]=(int)((pre_pro[i+1]*arr[i])%12345);

        int pro=1;
        int ans[] = new int[r*c];
        for(int i=0;i<r*c;i++)
        {
            ans[i]=(int)((pro*pre_pro[i+1])%12345);
            pro=(int)((pro*arr[i])%12345);
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
                grid[i][j]=ans[i*c+j];
        }

        return grid;
    }
}