class Solution 
{
    List<Integer> time_h;
    List<Integer> time_m;

    public void gethour(int arr[], int ind, int sum, int index)
    {
        if(ind<0 || ind>arr.length-index)
            return ;

        if(ind==0)
        {
            if(sum<12)
                time_h.add(sum);

            return ;
        }

        gethour(arr,ind,sum,index+1);
        gethour(arr,ind-1,sum+arr[index],index+1);

        return ;
    }

    public void getmin(int arr[], int ind, int sum, int index)
    {
        if(ind<0 || ind>arr.length-index)
            return ;

        if(ind==0)
        {
            if(sum<=59)
                time_m.add(sum);

            return ;
        }

        getmin(arr,ind,sum,index+1);
        getmin(arr,ind-1,sum+arr[index],index+1);

        return ;
    }


    public List<String> readBinaryWatch(int turnedOn) 
    {
        List<String> ans = new ArrayList<>();

        int hrs[] = {1,2,4,8};
        int min[] = {1,2,4,8,16,32};

        for(int i=0;i<=turnedOn;i++)
        {
            int hour = i;
            int mins = turnedOn - i;

            time_m = new ArrayList<>();
            time_h = new ArrayList<>();

            //recursive function to fill array
            gethour(hrs,hour,0,0);
            getmin(min,mins,0,0);

            for(int j=0;j<time_h.size();j++)
            {
                for(int k=0;k<time_m.size();k++)
                {
                    String st="";

                    if(time_m.get(k)<10)
                        st=time_h.get(j).toString()+":0"+time_m.get(k).toString();
                    else
                        st=time_h.get(j).toString()+":"+time_m.get(k).toString();

                    ans.add(st);
                }
            }
        }

        return ans;
    }
}