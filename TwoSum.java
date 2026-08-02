public int[] findTarget(int[] arr, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i<=arr.length-1 ; i++)
        {
            int comp = target - arr[i];

            if(map.containsKey(comp))
            {
                return new int[]{i, map.get(comp)};
            }
            else 
                map.put(arr[i],i);
        }

        return new int[]{};
    }
