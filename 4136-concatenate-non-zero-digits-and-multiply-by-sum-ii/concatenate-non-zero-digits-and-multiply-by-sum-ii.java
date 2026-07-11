class Solution 
{
    public int[] sumAndMultiply(String s, int[][] queries) 
    {
        //Mathematics heavy question concept of MOD can eliminate MLE.
        int MOD = 1000000007;
        int n = s.length();

        int pow_ten[] = new int[n+1];

        int pre_sum[] = new int[n+1];
        int pre_val[] = new int[n+1];
        int non_zero[] = new int[n+1];

        int ans[] = new int[queries.length];

        long val=1;
        for(int i=0;i<=n;i++)
        {
            pow_ten[i]=(int)val;
            val*=10;
            val%=MOD;
        }

        for(int i=0;i<n;i++)
        {
            int ch = s.charAt(i)-'0';
            pre_sum[i+1]=pre_sum[i]+ch;

            if(ch!=0)
            {
                non_zero[i+1]=1+non_zero[i];
                pre_val[i+1]=(int)((pre_val[i]*10L+ch)%MOD);
            }
            else
            {
                non_zero[i+1]=non_zero[i];
                pre_val[i+1]=pre_val[i];
            }

        }

        for(int i=0;i<queries.length;i++)
        {
            int low = queries[i][0];        int high = queries[i][1]+1;

            long remove = pre_val[low] * 1L *( pow_ten [ non_zero[high] - non_zero[low] ] );
            remove%=MOD;
            
            val = (pre_val[high]*1L-remove + MOD)%MOD;
            val*=(pre_sum[high]-pre_sum[low]);

            val%=MOD;
            ans[i]=(int)val;
        }

        return ans;
    }
}