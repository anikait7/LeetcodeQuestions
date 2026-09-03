//mathematics oriented question
class Solution 
{
    public boolean uniformArray(int[] nums1) 
    {
        int min=Integer.MAX_VALUE;

        for(int i : nums1)
            min=Math.min(min,i);

//if your minimum is odd hence make all elements odd -> even-odd = odd and copy all the odd no. NEW ARRAY CREATED SUCCESSFULLY
        if(min%2==1)
            return true;

//your minumum is even hence make all elements even -> odd - odd = even and copy all the even no.
        //the smallest odd no. can never be converted into even without being negative hence FALSE
        for(int i : nums1)
            if(i%2==1)
                return false;

        return true;
    }
}