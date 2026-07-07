class Solution 
{
    public long sumAndMultiply(int n) 
    {
        String st = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        int sum=0;

        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i)!='0')
            {
                sb.append(st.charAt(i));
                sum+=st.charAt(i)-'0';
            }
        }

        if(sb.length()==0)
            return 0;

        return 1L*Integer.parseInt(sb.toString())*sum;
    }
}