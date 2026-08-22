class Solution 
{
    int start;

    public int getCount(int arr[], int index, int lb, int ub, int x, int y)
    {
        //completely inside
        if(x<=lb && ub<=y)
            return arr[index];

        //completeley outside
        if(ub<x || lb>y)
            return 0;

        return getCount(arr,index*2,lb,(lb+ub)/2,x,y) + getCount(arr,index*2+1,(lb+ub)/2+1,ub,x,y);
    }

    public int buildSegmentTree(int arr[], int index)
    {
        //index>=arr.length -> leaf gets overwritten
        if(index>=start)
            return arr[index];

        return arr[index] = buildSegmentTree(arr,index*2) + buildSegmentTree(arr,index*2+1);
    }

    public int[] resultArray(int[] nums) 
    {
        /*
            This question is based on segment tree as it hints about continuous insertion and finding values above it
            Now since order is important we need to store numbers in sorted fashion
            Looking at constrains -> nums[i] is 10^9, an array will give me MLE hence we need to shrink the elements.

            Sort the elements and assign the least unique positive value. No. of positive value (nearest power of 2) will be the base of the tree and continuously form the upper layer until we get the last element as 1. (assuming 1 based indexing)
        */              

        Map<Integer,Integer> map = new HashMap<>();              //     val -> original no.

        Map<Integer,Integer> map_reverse = new HashMap<>();      //     original no. -> val

        int copy[] = nums.clone();
        Arrays.sort(copy);

        int val=1;

        map.put(val,copy[0]);
        map_reverse.put(copy[0],val++);

        for(int i=1;i<nums.length;i++)
        {
            if(copy[i-1]==copy[i])
                continue;
            else
            {
                map.put(val,copy[i]);
                map_reverse.put(copy[i],val++);
            }
        }

        for(int i=0;i<nums.length;i++)
            nums[i]=map_reverse.get(nums[i]);        

        int leaves = 1;
        while(leaves<val)
            leaves*=2;

        int totalNodes = leaves*2;
        start = leaves;           

        //initialization of segment tree  1 indexed 
        //the leaf node are on bottom ......... first element is the root

        int segmentA[] = new int[totalNodes];
        List<Integer> A = new ArrayList<>();

        int segmentB[] = new int[totalNodes];
        List<Integer> B = new ArrayList<>();

        int x = nums[0];      int y = nums[1];
        A.add(x);             B.add(y);
        segmentA[start+x-1]++;        segmentB[start+y-1]++;
        
        //build segment tree
        // int uvw = buildSegmentTree(segmentA,1);
        // uvw = buildSegmentTree(segmentB,1);

        int temp = start+x-1;
        while(temp>1)
        {
            temp/=2;
            segmentA[temp]++;
        }

        temp = start+y-1;
        while(temp>1)
        {
            temp/=2;
            segmentB[temp]++;
        }

        for(int i=2;i<nums.length;i++)
        {

            //getCount parameters -> segment no, [start_range to end_range]
            int abc = getCount(segmentA,1,1,leaves,nums[i]+1,val-1);
            int def = getCount(segmentB,1,1,leaves,nums[i]+1,val-1);

            if(abc>def)
            {
                A.add(nums[i]);
                segmentA[start+nums[i]-1]++;

                temp = start+nums[i]-1;
                while(temp>1)
                {
                    temp/=2;
                    segmentA[temp]++;
                }
            }
            else
            if(abc<def)
            {
                B.add(nums[i]);
                segmentB[start+nums[i]-1]++;

                temp = start+nums[i]-1;
                while(temp>1)
                {
                    temp/=2;
                    segmentB[temp]++;
                }
            }
            else
            {
                if(A.size()<=B.size())
                {
                    A.add(nums[i]);
                    segmentA[start+nums[i]-1]++;

                    temp = start+nums[i]-1;
                    while(temp>1)
                    {
                        temp/=2;
                        segmentA[temp]++;
                    }
                }
                else
                {
                    B.add(nums[i]);
                    segmentB[start+nums[i]-1]++;

                    temp = start+nums[i]-1;
                    while(temp>1)
                    {
                        temp/=2;
                        segmentB[temp]++;
                    }
                }
            }
        }

        A.addAll(B);

        int ans_final[] = new int[nums.length];
        for(int i=0;i<A.size();i++)
            ans_final[i]=map.get(A.get(i));

        return ans_final;
    }
}