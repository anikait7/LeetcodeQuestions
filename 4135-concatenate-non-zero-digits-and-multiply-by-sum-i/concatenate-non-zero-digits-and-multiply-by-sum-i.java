class Solution 
{
    public long sumAndMultiply(int n) 
    {
        String st = Integer.toString(n);
        String ans="";
        int sum=0;

        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i)!='0')
            {
                ans+=st.charAt(i);
                sum+=st.charAt(i)-'0';
            }
        }

        if(ans=="")
            return 0;

        return 1L*Integer.parseInt(ans)*sum;
    }
}