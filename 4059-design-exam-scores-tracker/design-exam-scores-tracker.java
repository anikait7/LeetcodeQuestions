class ExamTracker 
{
    List<Integer> time;
    List<Long> sum;
    int n=0;

    public ExamTracker() 
    {
        time = new ArrayList<>();
        sum = new ArrayList<>();
        sum.add(0L);
    }
    
    public void record(int t, int score) 
    {
       time.add(t);
       sum.add(sum.get(n++)+score);
    }

    public int find(int num)
    {
        int lb=0;   int ub=n-1;

        while(lb<=ub)
        {
            int mid = (lb+ub)/2;
   
            if(time.get(mid)<num)
                lb=mid+1;
            else
                ub=mid-1;
        }

        return lb;
    }
    
    public long totalScore(int startTime, int endTime) 
    {
        int x = find(startTime);
        int y = find(endTime+1);

        return sum.get(y)-sum.get(x);
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */