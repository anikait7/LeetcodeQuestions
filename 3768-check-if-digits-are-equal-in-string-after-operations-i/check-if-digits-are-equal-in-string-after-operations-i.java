class Solution 
{
    public boolean hasSameDigits(String s) 
    {
        while(s.length()>2)
        {
            char ch[] = new char[s.length()-1];
            for(int i=0;i<ch.length;i++)
            {
                int x=s.charAt(i)-'0';
                int y=s.charAt(i+1)-'0';
                ch[i]=(char)((x+y)%10 + '0');
            }
            s = new String(ch);
        }

        if(s.charAt(0)==s.charAt(1))
            return true;
        else
            return false;
    }
}