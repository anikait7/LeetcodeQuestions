class Solution 
{
    int i=-1;
    public String reverseParentheses(String s)
    {
        char [] ar = s.toCharArray();
        return stack(ar);
    }

    public String stack(char[] s)
    {
        StringBuilder sb = new StringBuilder();

        while(i<s.length-1)
        {
            i++;
            if(s[i]=='(')
                sb.append(stack(s));
            else
            if(s[i]==')')
                return sb.reverse().toString();
            else
                sb=sb.append(s[i]);
        }
        return sb.toString();
    }
}