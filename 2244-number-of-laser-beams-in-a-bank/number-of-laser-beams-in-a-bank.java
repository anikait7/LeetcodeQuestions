class Solution 
{
    public int numberOfBeams(String[] bank) 
    {
        int count=0;
        int prev=0;

        for(int i=0;i<bank.length;i++)
        {
            int c=0;
            for(int j=0;j<bank[i].length();j++)
                if(bank[i].charAt(j)=='1')
                    c++;
            
            if(c==0)
                continue;

            if(prev==0)
            {
                prev=c;
                continue;
            }

            count+=prev*c;
            prev=c;
        }

        return count;
    }
}