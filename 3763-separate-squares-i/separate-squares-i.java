class Solution 
{
    public double separateSquares(int[][] squares) 
    {
        int n = squares.length;
        int max=0;
        double total=0.0;

        for(int i=0;i<n;i++)
        {
            max=Math.max(max,squares[i][1]+squares[i][2]);
            total+=(double)squares[i][2]*squares[i][2]*1.0;
        }

        Arrays.sort(squares, (a,b) -> a[1]-b[1]);

        double lb=0;       double ub=max;
        while(ub-lb>1e-6)
        {
            double mid = (lb+ub)/2;
            double sum=0.0;

            for(int i=0;i<n && squares[i][1]<mid;i++)
            {
                sum+=(Math.min(squares[i][1]+squares[i][2],mid)-squares[i][1])*squares[i][2];
            }

            if(2*sum>=total)
                ub=mid;
            else
                lb=mid;
        }
        
        return ub;
    }
}