class Solution 
{
    public int largestPrime(int n) 
    {
        List<Integer> prime = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        boolean flag[] = new boolean[n+1];
        Arrays.fill(flag,true);

        for(int i=2;i<=n;i++)
        {
            if(flag[i])
            {
                for(int j=i*2;j<=n;j+=i)
                    flag[j]=false;

                set.add(i);
                prime.add(i);
            }
        }

        int max=0;        int sum=0;

        for(int i=0;i<prime.size();i++)
        {
            sum+=prime.get(i);
            if(set.contains(sum))
                max=sum;
        }
        
        return max;
    }
}