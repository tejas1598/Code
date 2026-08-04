public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0; 
        int currentLength = 0;
        
        for(int n : nums)
        {
            set.add(n);
        }

        for(Integer number : set)
        {
            if(!set.contains(number-1))
            {
                currentLength = 1;

                while (set.contains(number + 1))
                {
                    currentLength++;
                    number++;
                }

                maxLength = Math.max(currentLength , maxLength);
            }
        }

        return maxLength;
    }
