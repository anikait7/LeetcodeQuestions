class MyCalendarThree 
{
    List<int []> list;

    public MyCalendarThree() 
    {
        list = new ArrayList<>();
    }
    
    public int book(int startTime, int endTime) 
    {
        // 1 -> start    -1 -> end
        list.add(new int[]{startTime,1});
        list.add(new int[]{endTime,-1});

        Collections.sort(list, (x,y) -> {
            if(x[0]==y[0])
                return Integer.compare(x[1],y[1]);
            else
                return Integer.compare(x[0],y[0]);
        });

        int max=0;
        int count=0;

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)[1]==1)
                count++;
            else
                max=Math.max(max,count--);
        }

        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */