public int firstNonRepeating(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0 ; i<arr.length ; i++)
        {
            if(map.containsKey(arr[i]))
            {
                int num = map.get(arr[i]);
                map.put(arr[i],num+1);
            }
            else
                map.put(arr[i],1);
        }
        
        for(int j = 0; j<arr.length ; j++)
        {
            if(map.get(arr[j]) == 1)
            {
                return arr[j];
            }
        }    
        
        return -1;
    }
