class Solution 
{    
    public int maxActiveSectionsAfterTrade(String s) 
    {
        List<Integer> list = new ArrayList<>();
        int ones=0;       int zeros=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                ones++;
                
                if(zeros!=0)
                    list.add(zeros);
                zeros=0;
            }
            else
                zeros++;
        }

        if(zeros!=0)
            list.add(zeros);

        int sum=0;

        if(list.size()>=2)
        {
            sum=list.get(0)+list.get(1);
            for(int i=2;i<list.size();i++)
                sum=Math.max(sum,list.get(i)+list.get(i-1));
        }

        return ones+sum;
    }
}