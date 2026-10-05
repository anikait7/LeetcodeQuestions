class Solution 
{
    int ind=0;

    public int recursive(String st)
    {
        int count=0;
        while(ind<st.length())
        {
            if(st.charAt(ind)==')')
            {
                ind++;
                return count;
            }
            else
            if(st.charAt(ind)=='(' && st.charAt(ind+1)=='(')
            {
                ind++;
                count+=2*(recursive(st));
            }
            else
            {
                ind+=2;
                count++;
            }
        }

        return count;
    }

    public int scoreOfParentheses(String s) 
    {
        return recursive(s);
        /*
            example 1:  (())
                        ( 1 )
                        option a) 1*2=2
                        option b) 1+1=2

             example 1:  (()())
                        ( 1 + 1 )
                        option a) 2*2=4
                        option b) 1+1+1=2
        */

        /*
            ( ( () () ) () )

            (
                (
                    1+1
        */
    }
}