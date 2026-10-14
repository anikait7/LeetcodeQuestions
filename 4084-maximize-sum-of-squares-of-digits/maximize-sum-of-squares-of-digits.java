class Solution 
{
    public String maxSumOfSquares(int num, int sum) 
    {
        if(num*9<sum)
            return "";

        StringBuilder sb = new StringBuilder();

        for(int i=9;i>=1;i--)
        {
            int x = sum/i;
            if(x!=0)
                sb.repeat(String.valueOf(i),x); 
            sum-=x*i;
        }

        int left = num-sb.length();
        sb.repeat("0",left);

        return sb.toString();
    }
}