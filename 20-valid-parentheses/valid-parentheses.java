class Solution 
{
    public boolean isValid(String s) 
    {
        if(s.length()%2==1)
            return false;

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if(ch==')' || ch=='}' || ch==']')
            {
                if(stack.isEmpty())
                    return false;

                char ch1=stack.pop();
                switch(ch)
                {
                    case ')' :  if(ch1!='(')
                                    return false;
                                break;

                    case ']' :  if(ch1!='[')
                                    return false;
                                break;

                    case '}' :  if(ch1!='{')
                                    return false;
                }
            }
            else
                stack.push(ch);
        }

        if(stack.size()>0)
            return false;

        return true;
    }
}