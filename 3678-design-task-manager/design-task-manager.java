class TaskManager 
{
    Set<List<Integer>> set;
    PriorityQueue<List<Integer>> pq;
    Map<Integer,List<Integer>> map;

    public TaskManager(List<List<Integer>> tasks) 
    {
        set = new HashSet<>();
        map = new HashMap<>();

        pq = new PriorityQueue<>((a,b) -> {

            if(!a.get(2).equals(b.get(2))) 
                return b.get(2)-a.get(2); 
            
            return b.get(1)-a.get(1);
        });

        for(List<Integer> list : tasks)
        {
            pq.add(list);

            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0));         temp.add(list.get(2));

            //putting userId and priority in map
            map.put(list.get(1),temp);
        }
    }
    
    public void add(int userId, int taskId, int priority) 
    {
        List<Integer> list = new ArrayList<>();
        list.add(userId);
        list.add(taskId);
        list.add(priority);

        pq.add(list);

        List<Integer> temp = new ArrayList<>();
        temp.add(userId);         temp.add(priority);

        map.put(taskId,temp);         
    }
    
    public void edit(int taskId, int newPriority) 
    {
        List<Integer> temp = map.get(taskId);
        
        //checking if the priority is same as previous
        if(newPriority==temp.get(1))
            return ;

        map.remove(taskId);

        List<Integer> aa = new ArrayList<>();
        aa.add(temp.get(0));
        aa.add(newPriority);
        
        map.put(taskId,aa);

        List<Integer> list = new ArrayList<>();
        list.add(temp.get(0));
        list.add(taskId);
        list.add(newPriority);
        pq.add(list);

        List<Integer> xyz = new ArrayList<>();
        xyz.add(temp.get(0));
        xyz.add(taskId);
        xyz.add(temp.get(1));
        
        set.add(xyz);
    }
    
    public void rmv(int taskId) 
    {
        List<Integer> temp = map.get(taskId);

        List<Integer> xyz = new ArrayList<>();
        xyz.add(temp.get(0));
        xyz.add(taskId);
        xyz.add(temp.get(1));
        
        set.add(xyz);
        map.remove(taskId);
    }
    
    public int execTop() 
    {
        while(!pq.isEmpty())
        {
            List<Integer> temp = pq.poll();

            if(set.contains(temp))
            {
                set.remove(temp);
                continue;
            }
            else
            {
                map.remove(temp.get(1));
                return temp.get(0);
            }
        }

        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */