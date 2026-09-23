class Solution {
    public int minOperations(int[] nums, int x) {
        int sum  = 0;
        for(int num : nums) {
            sum += num;
        }

        int target = sum - x;
        int right = 0;
        sum = 0;
        int len = -1;

        for(int left = 0; left < nums.length; left++) {
            sum += nums[left];
            while(right <= left && sum > target) {
                sum -= nums[right];
                right++;
            }

            if(sum == target) {
                len = Math.max(len, left - right + 1);
               // break;
            }
        }

        return (len == -1) ? -1 : nums.length - len;
    } 
}