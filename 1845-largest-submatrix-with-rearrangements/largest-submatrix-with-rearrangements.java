class Solution 
{
    public int largestSubmatrix(int[][] matrix) 
    {
        int count=0;
        int r = matrix.length;    int c = matrix[0].length;

        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                if(matrix[j][i]==1)
                    matrix[j][i]=1+(j-1<0 ? 0 : matrix[j-1][i]);
            }
        }

        for(int i=0;i<r;i++)
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j=0;j<c;j++)
            {
                if(matrix[i][j]!=0)
                    pq.add(matrix[i][j]);
            }

            while(!pq.isEmpty())
                count=Math.max(count,pq.size()*pq.poll());
        }

        return count;
    }
}