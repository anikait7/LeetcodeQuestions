class Bank 
{
    long arr[];
    int n;

    public Bank(long[] balance) 
    {
        n=balance.length+1;
        arr = new long[balance.length+1];

        for(int i=1;i<=balance.length;i++)
            arr[i]=balance[i-1];
    }
    
    public boolean transfer(int account1, int account2, long money) 
    {
        if(account2>n || account1>n)
            return false;

        if(arr[account1]>=money)
        {
            arr[account1]-=money;
            arr[account2]+=money;
            return true;
        }

        return false;
    }
    
    public boolean deposit(int account, long money) 
    {
        if(account>n)
            return false;

        arr[account]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) 
    {
        if(account>n || arr[account]-money<0)
            return false;

        arr[account]-=money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */