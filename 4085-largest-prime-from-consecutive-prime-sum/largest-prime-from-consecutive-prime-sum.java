class Solution 
{
    public int largestPrime(int n) 
    {
        List<Integer> prime = new ArrayList<>();

        boolean flag[] = new boolean[n+1];
        Arrays.fill(flag,true);

        for(int i=2;i<=n;i++)
        {
            if(flag[i])
            {
                for(int j=i*2;j<=n;j+=i)
                    flag[j]=false;

                prime.add(i);
            }
        }

        int max=0;        int sum=0;

        for(int i=0;i<prime.size();i++)
        {
            sum+=prime.get(i);
            if(sum>n)
                break;
                
            if(flag[sum])
                max=sum;
        }
        
        return max;
    }
}