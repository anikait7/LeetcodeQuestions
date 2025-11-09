class Solution 
{
    public String maxSumOfSquares(int num, int sum) 
    {
        StringBuilder sb = new StringBuilder();
        int c=1;

        while(sum!=0 || c<=num)
        {
            for(int i=Math.min(sum,9);i>=0;i--)
            {
                if(sum-i>=0)
                {
                    sum-=i;
                    sb.append((char)('0'+i));
                    break;
                }
            }
            c++;
        }

        if(sb.length()>num)
            return "";

        return sb.toString();
    }
}