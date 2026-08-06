class Solution 
{
    public void recursive(int nums[], int start, int end, int sum, int count, List<int []> temp)
    {
        if(start==end)
        {
            temp.add(new int[]{sum,count});
            return ;
        }

        recursive(nums,start+1,end,sum,count,temp);

        recursive(nums,start+1,end,sum+nums[start],count+1,temp);
    }

    public boolean splitArraySameAverage(int[] nums) 
    {
        int SUM=0;
        for(int i : nums)
            SUM+=i;

        //       sum,count -> get avg with the same
        List<int []> left = new ArrayList<>();
        List<int []> right = new ArrayList<>();

        int len = nums.length;
        int n1 = len/2;

        recursive(nums,0,n1,0,0,left);
        recursive(nums,n1,len,0,0,right);

        //on combining left and right (both cant have count=0) can i get value as AVG return the same

        Collections.sort(right, (a,b) -> {
            if(a[1]!=b[1])
                return Integer.compare(a[1],b[1]);

            return Integer.compare(a[0],b[0]);
        });

        for(int temp[] : left)
        {
            int sum = temp[0];
            int count = temp[1];

            for(int i=0;i<=len-n1;i++)
            {
                if(count+i==0 || count+i==len)
                    continue;

                int lb1=0;  int ub1=right.size()-1;
                while(lb1<=ub1)
                {
                    int mid = (lb1+ub1)/2;

                    if(right.get(mid)[1]<i)
                        lb1=mid+1;
                    else
                        ub1=mid-1;                    
                }

                int lb2=0;  int ub2=right.size()-1;
                while(lb2<=ub2)
                {
                    int mid = (lb2+ub2)/2;

                    if(right.get(mid)[1]<i+1)
                        lb2=mid+1;
                    else
                        ub2=mid-1;                    
                }

                //lb1 is starting point
                //lb2-1 is ending point

                //mathematics comes here double int issue is caused thats why 109/111 in the first try

                int totalCount = count+i;
                if((SUM*totalCount)%len!=0)
                    continue;

                int find = SUM*totalCount/len -sum;

                int x = lb1;    int y = lb2-1;

                while(x<=y)
                {
                    int mid = (x+y)/2;

                    if(right.get(mid)[0]==find)
                        return true;

                    if(right.get(mid)[0]<find)
                        x=mid+1;
                    else
                        y=mid-1;
                }
            }
        }

        return false;
    }
}