class Solution 
{
    Map<Integer,List<Long>> map = new HashMap<>();

    //LCM for group of i elements called from function recursive THIS IS GIVING TLE 
    /*
    public long getLCM(List<Integer> list)
    {
        long temp = list.get(list.size()-1);

        boolean flag=true;      

        while(flag)
        {
            int count=0;

            for(int i=0;i<list.size();i++)
                if(temp%list.get(i)==0)
                    count++;

            if(count==list.size())
                flag=false;
            else
                temp+=list.get(list.size()-1);
        }

        return temp;
    }
    */

    //calculate lcm using gcd
    public long gcd(long a, long b)
    {
        while(b!=0)
        {
            long temp = a%b;
            a=b;
            b=temp;
        }

        return a;
    }

    //making groups of c and adding their lcm in map
    public void recursive(int coins[], int index, int count, int c, long b, long currentLCM)
    {
        if(count==0)
        {
            map.get(c).add(currentLCM);
            return ;
        }

        if(index==coins.length)
            return ;

        //SKIP
        recursive(coins,index+1,count,c,b,currentLCM);

        //INCLUDE
        b = gcd(coins[index],currentLCM);
        long newLCM = currentLCM/b*coins[index];

        recursive(coins,index+1,count-1,c,b,newLCM);

        /*
            What this functions does
            LCM * HCF = num1 * num2
            Since we know computing LCM is of high TC, we find HCF aka GCD and then find LCM preventing TLE
            Every time I assume to include a number -> LCM = num1*num2/gcd
                                                            num1 = currentLCM 
                                                            num2 = coins[index] (i am including it)

                                                            GCD = gcd of (coins[index],currentLCM)

                                            All these combined gives me new LCM which i pass in the recursion
        */
    }

    public long findKthSmallest(int[] coins, int k) 
    {
        int n = coins.length;
        Arrays.sort(coins);

        long ans=1;
        long lb=1;  long ub=coins[n-1]*1L*k;

        for(int i=1;i<=n;i++)
            map.put(i, new ArrayList<>());

        for(int i=1;i<=n;i++)
        {
            recursive(coins,0,i,i,1,1);
        }

        long LCM = map.get(1).get(0);

        while(lb<=ub)
        {
            long mid = lb + (ub-lb)/2;
            int sign=1;

            long count=0;

            for(int i=1;i<=n;i++)
            {
                List<Long> temp = map.get(i);

                for(long j : temp)
                    count+=sign*mid/j;

                sign=-sign;
            }

            if(count>=k)
            {
                ub=mid-1;
                ans = (mid/LCM+1)*LCM;
            }
            else
                lb=mid+1;
        }

        return lb;
    }
}