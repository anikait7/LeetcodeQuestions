class Solution 
{
    public boolean checkValidString(String s) 
    {
        int min=0;      int max=0;

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                min++;
                max++;
            }
            else
            if(ch==')')
            {
                max--;
                if(max<0)
                    return false;

                min=Math.max(0,min-1);
            }
            else
            {
                max++;
                min=Math.max(0,min-1);
            }
        }

        if(min==0)
            return true;
        else
            return false;
    }
}