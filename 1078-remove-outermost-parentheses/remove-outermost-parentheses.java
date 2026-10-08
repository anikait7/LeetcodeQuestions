class Solution 
{
    public String removeOuterParentheses(String s) 
    {
        List<String> list = new ArrayList<>();

        StringBuilder temp = new StringBuilder();
        int last=0;   int c=0;

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(ch=='(')
                c++;
            else
                c--;

            temp.append(ch);

            if(c==0)
            {
                list.add(temp.toString());
                temp = new StringBuilder();
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<list.size();i++)
            sb.append(list.get(i).substring(1,list.get(i).length()-1));

        return sb.toString();
    }
}