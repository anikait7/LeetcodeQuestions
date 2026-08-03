//Meet in the Middle Problem -> used when 2^length gives TLE but dividing it into two doesnt give TLE merge should be efficient

class Solution 
{
    Set<Integer> list1 = new HashSet<>();
    Set<Integer> list2 = new HashSet<>();
    //since duplicates have no use better to ignore it using hashset

    public void recursive(int nums[], int i, int j, int sum, Set<Integer> list)
    {
        if(i==j)
        {
            list.add(sum);
            return;
        }

        recursive(nums,i+1,j,sum,list);
        recursive(nums,i+1,j,sum+nums[i],list);
    }

    public int minAbsDifference(int[] nums, int goal) 
    {
        int len = nums.length;
        int n1 = len/2;  //0 to less than 5
        int n2 = len-n1; //n2 to less than len

        recursive(nums,0,n1,0,list1); //all valid subsequence from 0 to <n1
        recursive(nums,n1,len,0,list2); //all valid subsequence from n1 to <len

        List<Integer> list = new ArrayList<>(list2);
        Collections.sort(list);

        int min = Math.abs(goal);
        //now merge the result 

        for(int x : list1)
        {
            int target = goal-x;

            int idx = Collections.binarySearch(list,target);
            //java returns -(insertionPoint) -1 if not found

            //exact match found
            if(idx>=0)
                return 0;

            //recovering the insertion point
            idx = -idx-1;

            if(idx<list.size())
                min=Math.min(min,Math.abs(x+list.get(idx)-goal));

            if(idx>0)
                min=Math.min(min,Math.abs(x+list.get(idx-1)-goal));            
        }

        return min;
    }
}

/*
{0,7,-9,-2} {0,15,-2,13}  goal=-5
{0,7,-9,-2} {-2,0,13,15} 
    eqn:   (x1+x2) - goal = min &&
           (x1+x2) - goal = -min

        here we need min to be 0 and we need to find x2
        x2=goal-x1
        x2=x1-goal
*/