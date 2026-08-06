class Solution 
{
    int n;      int len;    

    public void recursive(int nums[], int start, int end, int sum, int count, List<int []> list)
    {
        if(start==end)
        {
            list.add(new int[]{sum,count});
            return ;
        }

        recursive(nums,start+1,end,sum,count,list);

        recursive(nums,start+1,end,sum+nums[start],count+1,list);
    }


    public int minimumDifference(int[] nums) 
    {
        int min = Integer.MAX_VALUE;
        n = nums.length/2;
        len = nums.length;

        //global sum variable
        int SUM=0;
        for(int i:nums)
            SUM+=i;

        //0 to n
        List<int []> list1 = new ArrayList<>();
        recursive(nums,0,n,0,0,list1);

        // n to len
        List<int []> list2 = new ArrayList<>();
        recursive(nums,n,len,0,0,list2);

        //now merging the subset

        //sort based on count 
        Collections.sort(list2,(a,b) -> {
            if(a[1]!=b[1])
                return Integer.compare(a[1],b[1]);

            return Integer.compare(a[0],b[0]);
        });

        for(int temp[] : list1)
        {
            int c = temp[1];    int s = temp[0];
            int find = n-c;

            //apply binary search to get  
            int lb=0;   int ub=list2.size()-1;
            while(lb<=ub)
            {
                int mid = (lb+ub)/2;

                if(list2.get(mid)[1]>=find)
                    ub=mid-1;
                else
                    lb=mid+1;
            }

            int lb1=0;   int ub1=list2.size()-1;
            while(lb1<=ub1)
            {
                int mid = (lb1+ub1)/2;

                if(list2.get(mid)[1]>=find+1)
                    ub1=mid-1;
                else
                    lb1=mid+1;
            }

            //range from lb to less than lb1
            //find 2*(leftsum+rightsum)=SUM
            //rightsum = SUM/2-leftsum. FIND THIS IN THE ARRAY

            int target = SUM/2-s;

            int x = lb;     int y = lb1-1;

            while(x<=y)
            {
                int mid = (x+y)/2;

                if(list2.get(mid)[0]<target)
                    x=mid+1;
                else
                    y=mid-1;                
            }

            if(x<lb1)
                min=Math.min(min,Math.abs(SUM-2*(s+list2.get(x)[0])));

            if(x-1>=lb)
                min=Math.min(min,Math.abs(SUM-2*(s+list2.get(x-1)[0])));
        }

        return min;
    }
}

/*  This code is giving TLE becasue of 2^30 computation. We need to split into two parts of 15 each

    if(count==n)
        {
            min = Math.min(min,Math.abs(sum-(SUM-sum)));
            return ;
        }

        if(n-count>nums.length-index)
            return ;

        //exclude element
        recursive(index+1,sum,count,nums);

        //include element
        recursive(index+1,sum+nums[index],count+1,nums);
        
        n = nums.length/2;

        for(int i : nums)
            SUM+=i;

        recursive(0,0,0,nums);

        return min;
*/