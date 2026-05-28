class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;

        // Handle cases where k > n
        k = k % n;

        // Step 1: Reverse whole array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {

        while(start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
