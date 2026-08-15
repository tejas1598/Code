public int[] productExceptSelf(int[] nums)
    {
        int slow = 1;
        
        int leftProduct = 1;
        int rightProduct = 1;

        int[] result = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++)
        {
                result[i] = leftProduct;
                leftProduct = leftProduct * nums[i];
        }

        for(int j = nums.length-1 ; j >= 0 ; j--)
        {
            result[j] = rightProduct * result[j];
            rightProduct = rightProduct * nums[j];
        }

        return result;
    }
