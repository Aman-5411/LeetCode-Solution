class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        long sum = 0;

        int left = 0, right = nums.length - 1;

        while(left < right) {
            sum = sum + (nums[right--] - nums[left++]);
        }

        if(nums.length % 2 != 0)     sum = sum + nums[nums.length / 2];
        return sum;
    }
}