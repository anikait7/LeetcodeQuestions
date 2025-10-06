class MovieRentingSystem 
{
    Map<List<Integer>,Integer> map = new HashMap<>();   // (shop+movie) -> cost
    Map<Integer,TreeSet<List<Integer>>> data = new HashMap<>(); // movie -> (shop+cost)

    TreeSet<List<Integer>> rented = new TreeSet<>((x,y) -> {       //shop + movie + price
                    if(!x.get(2).equals(y.get(2)))
                        return x.get(2)-y.get(2);
                    if(!x.get(0).equals(y.get(0)))
                        return x.get(0)-y.get(0);
                    else
                        return x.get(1)-y.get(1);
                });

    public MovieRentingSystem(int n, int[][] entries) 
    {
        for(int a[] : entries)
        {
            map.put(Arrays.asList(a[0],a[1]),a[2]);  // (shop+movie) -> cost

            if(data.containsKey(a[1]))
                data.get(a[1]).add(Arrays.asList(a[0],a[2]));  // movie -> (shop+cost)
            else
            {
                TreeSet<List<Integer>> p = new TreeSet<>((x,y) -> {
                    if(!x.get(1).equals(y.get(1)))
                        return x.get(1)-y.get(1);
                    else
                        return x.get(0)-y.get(0);
                });

                data.put(a[1],p);
                data.get(a[1]).add(Arrays.asList(a[0],a[2]));  // movie -> (shop+cost)
            }
        }
    }
    
    public List<Integer> search(int movie) 
    {
        List<Integer> result = new ArrayList<>();
        if(!data.containsKey(movie))
            return result;

        int c=0;
        for(List<Integer> a : data.get(movie))
        {
            if(c>=5)
                break;

            result.add(a.get(0));
            c++;
        }

        return result;
    }
    
    public void rent(int shop, int movie) 
    {
       List<Integer> temp = Arrays.asList(shop,movie);
       int x = map.get(temp);

       data.get(movie).remove(Arrays.asList(shop,x));
       List<Integer> temp1 = Arrays.asList(shop,movie,x);
       rented.add(temp1);
    }
    
    public void drop(int shop, int movie) 
    {
        List<Integer> temp = Arrays.asList(shop,movie);
        int x = map.get(temp);

        rented.remove(Arrays.asList(shop,movie,x));
        data.get(movie).add(Arrays.asList(shop,x));  
    }
    
    public List<List<Integer>> report() 
    {
        List<List<Integer>> list = new ArrayList<>();
        int c=0;

        for(List<Integer> a : rented)
        {
            if(c>=5)
                break;

            list.add(Arrays.asList(a.get(0),a.get(1)));
            c++;
        }       

        return list;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */