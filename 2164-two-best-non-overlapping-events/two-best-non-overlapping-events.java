class Solution 
{
    public int maxTwoEvents(int[][] events) 
    {
        int sum=0,max=0,x=0;
        int a[][] = new int[events.length*2][3];

        for(int i=0;i<events.length;i++)
        {
            a[i*2][0]=events[i][0];
            a[i*2][1]=1;
            a[i*2][2]=events[i][2];

            a[i*2+1][0]=events[i][1]+1;
            a[i*2+1][1]=-1;
            a[i*2+1][2]=events[i][2];
        }

        Arrays.sort(a, new Comparator<int[]>()
        {
            public int compare(final int x[], final int y[])
            {
                if(x[0]>y[0])
                    return 1;
                else
                if(x[0]<y[0])
                    return -1;
                else
                    return Integer.compare(x[1],y[1]);
            }
        });

        for(int i=0;i<a.length;i++)
        {            
            sum=0;
            if(a[i][1]==-1)
                x=Math.max(x,a[i][2]);
            else
                sum=a[i][2];

            sum=sum+x;
            if(sum>max)
                max=sum;
        }
        
        return max;
    }
}