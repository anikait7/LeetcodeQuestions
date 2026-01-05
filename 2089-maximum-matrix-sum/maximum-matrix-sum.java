class Solution 
{
    public long maxMatrixSum(int[][] matrix) 
    {
        int i,j;
        int c=0;
        int min=Integer.MAX_VALUE;
        long sum=0;

        for(i=0;i<matrix.length;i++)
        {
            for(j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]<0)
                    c++;
                sum=sum+Math.abs(matrix[i][j]);
                if(Math.abs(matrix[i][j])<min)
                    min=Math.abs(matrix[i][j]);
            }
        }

        if(c%2==0)
            return sum;
        else
            return sum-min*2;
    }
}