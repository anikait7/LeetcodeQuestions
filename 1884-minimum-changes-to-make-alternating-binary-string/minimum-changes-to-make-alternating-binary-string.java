class Solution 
{
    public int minOperations(String s) 
    {
        int a=0;    int b=0;
        int temp=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)-'0'!=temp)
                a++;
            
            temp=1-temp;

            if(s.charAt(i)-'0'!=temp)
                b++;
        }

        return Math.min(a,b);
    }
}