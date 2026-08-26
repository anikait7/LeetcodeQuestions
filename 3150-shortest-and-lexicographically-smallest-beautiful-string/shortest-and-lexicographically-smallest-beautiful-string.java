class Solution 
{
    public String shortestBeautifulSubstring(String s, int k) 
    {
        int n = s.length();
        String ans = "";

        int c=0;
        int left=0;

        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
                c++;

            if(c==k)
            {
                while(left<=i && s.charAt(left)=='0')
                    left++;

                String temp = s.substring(left,i+1);
                
                if(ans=="" || temp.length()<ans.length() || (ans.length()==temp.length() && ans.compareTo(temp)>0))
                    ans=temp;

                c--;
                left++;                
            }
        }

        return ans;
    }
}