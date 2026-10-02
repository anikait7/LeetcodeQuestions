class Solution 
{
    List<String> answer = new ArrayList<>();

    public void recursive(int x, int y, StringBuilder sb)
    {
        if(x==0 && y==0)
        {
            answer.add(sb.toString());
            return ;
        }

        if(x==y)
        {
            sb.append('(');
            recursive(x-1,y,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else
        {
            if(x!=0)
            {
                sb.append('(');
                recursive(x-1,y,sb);
                sb.deleteCharAt(sb.length()-1);
            }

            sb.append(')');
            recursive(x,y-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) 
    {
        recursive(n,n,new StringBuilder());
        return answer;
    }
}