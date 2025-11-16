class Solution 
{
    public int numSub(String s) 
    {
        s+="0";
        long c=0;

        int left=0;
        int right=0;

        while(right<s.length())
        {
            if(s.charAt(right)=='0')
            {
                while(left<=right)
                {
                    c+=(right-left);

                    left++;
                    c%=1000000007;
                }

                right++;
            }
            else
                right++;
        }


        return (int)(c%1000000007);
    }
}