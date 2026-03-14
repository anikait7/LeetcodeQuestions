class Solution 
{
    int count=1;
    public String recursive(int k, int len, String ans)
    {
        if(len==0)
        {
            if(count==k)
                return ans;
            else
            {
                count++;
                return "";
            }
        }

        String st;
        int x=ans.length()-1;

        if(ans.charAt(x)=='a')
        {
            st=recursive(k,len-1,ans+"b");
            if(!st.equals(""))
                return st;
            
            st=recursive(k,len-1,ans+"c");
            if(!st.equals(""))
                return st;
        }

        if(ans.charAt(x)=='b')
        {
            st=recursive(k,len-1,ans+"a");
            if(!st.equals(""))
                return st;

            st=recursive(k,len-1,ans+"c");
            if(!st.equals(""))
                return st;
        }

        if(ans.charAt(x)=='c')
        {
            st=recursive(k,len-1,ans+"a");
            if(!st.equals(""))
                return st;

            st=recursive(k,len-1,ans+"b");
            if(!st.equals(""))
                return st;
        }

        return "";
    }
    
    public String getHappyString(int n, int k) 
    {
        String st;

        st=recursive(k,n-1,"a");

        if(!st.equals(""))
            return st;

        st=recursive(k,n-1,"b");
        if(!st.equals(""))
            return st;

        st=recursive(k,n-1,"c");
        return st;
    }       
}