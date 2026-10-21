class Solution 
{
    public int minOperations(String s)
    {
        int n = s.length();

        if(n==1)
            return 0;

        if(n==2)
        {
            if(s.charAt(0)<=s.charAt(1))
                return 0;
            else
                return -1;
        }

        boolean flag=true;
        int min=s.charAt(0)-'a'; int max=s.charAt(0)-'a';

        for(int i=1;i<n;i++)
        {
            if(flag && s.charAt(i-1)>s.charAt(i))
                flag=false;
            
            min = Math.min(min,s.charAt(i)-'a');
            max = Math.max(max,s.charAt(i)-'a');
        }

        if(flag)
            return 0;

        if(min==s.charAt(0)-'a' || max==s.charAt(n-1)-'a')
            return 1;
        
        for(int i=1;i<n-1;i++)
        {
            int ch = s.charAt(i)-'a';

            if(ch==min || ch==max)
                return 2;
        }

        return 3;
    }
}