class Solution 
{
    int x[][];
    int N;
    
    public int recursive(int index, int last)
    {
        if(last>=N)
            return 0;

        if(index==x.length)
            return N+2;

        if(x[index][0]>last)
            return N+2;

        
        int copy=last;
        int ptr=index;  

        for(int i=index;i<x.length;i++)
        {            
            if(x[i][0]>last)
                break;

            if(x[i][1]>copy)
            {
                copy=x[i][1];
                ptr=i;
            }
        }

        return 1+recursive(ptr+1,copy);
    }

    public int minTaps(int n, int[] ranges) 
    {
        N=n;
        int len = ranges.length;
        x = new int[len][2];

        for(int i=0;i<len;i++)
            Arrays.fill(x[i],-1);

        int start=0;

        for(int i=0;i<len;i++)
        {
            if(ranges[i]==0)
            {
                start++;
                continue;
            }

            x[i][0]=Math.max(0,i-ranges[i]);
            x[i][1]=Math.min(n,i+ranges[i]);
        }

        Arrays.sort(x, (a,b) -> {
            if(a[0]!=b[0])
                return Integer.compare(a[0],b[0]);
            else
                return Integer.compare(b[1],a[1]);
        });

        if(start==len)
            return -1;

        if(x[start][0]!=0)
            return -1;

        int ans = 1+recursive(start+1,x[start][1]);

        if(ans>=N+2)
            return -1;
        else
            return ans;
    }
}