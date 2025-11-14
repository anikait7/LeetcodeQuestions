class Solution 
{
    public int[][] rangeAddQueries(int n, int[][] queries) 
    {
        int mat[][] = new int[n+1][n+1];

        for(int i=0;i<queries.length;i++)
        {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            for(int j=r1;j<=r2;j++)
            {
                mat[j][c1]++;
                mat[j][c2+1]--;
            }
        }

        int matrix[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=0;j<n;j++)
            {
                sum+=mat[i][j];
                matrix[i][j]=sum;
            }
        }

        return matrix;
    }
}