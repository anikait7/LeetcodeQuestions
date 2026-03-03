class Solution 
{
    public String reverse(String st)
    {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i)=='0')
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.reverse().toString();
    }

    public char findKthBit(int n, int k) 
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder("0");

        if(n==1)
            return '0';

        for(int i=2;i<=n;i++)
        {
            sb.append(sb1.toString());
            sb.append("1");
            sb.append(reverse(sb1.toString()));            
            sb1.setLength(0);
            sb1.append(sb.toString());
            sb.setLength(0);
        }

        return sb1.charAt(k-1);
    }
}