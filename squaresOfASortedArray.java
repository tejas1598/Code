public int[] squareSortArray(int[] arr)
    {
        int[] result = new int[arr.length];

        int startIndex = 0; 
        int endIndex = arr.length-1;
        
        //   *         *
        // {-4, -1, 0, 3, 10}
        // [ 0   1  2  3   4 ]

        int i = arr.length-1;
        
        while(startIndex <= endIndex)
        {
            int multA = arr[startIndex]*arr[startIndex];
            int multB = arr[endIndex]*arr[endIndex];

            if(multA>multB)
            {
                result[i] = multA;
                startIndex++;
                i--;
            }
            else
            {    
                result[i] = multB;
                endIndex--;
                i--;
            }
        }

        return result;
    }
