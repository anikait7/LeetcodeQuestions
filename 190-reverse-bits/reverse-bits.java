public class Solution 
{
    // you need treat n as an unsigned value
    public int reverseBits(int n) 
    {
        StringBuilder sb = new StringBuilder();
        int num=0;

        while(sb.length()!=32)
        {
            int c = n%2;           n/=2;

            if(c==0)
                sb.append("0");
            else
                sb.append("1");
        }

        for(int i=0;i<sb.length();i++)
            num+=Math.pow(2,31-i)*(sb.charAt(i)-'0');

        return num;
    }
}