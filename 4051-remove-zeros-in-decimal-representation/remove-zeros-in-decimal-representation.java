class Solution
{
    public long removeZeros(long n)
    {
        String st = Long.toString(n);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<st.length();i++)
            if(st.charAt(i)!='0')
                sb.append(st.charAt(i));

        return Long.parseLong(sb.toString());
    }
}