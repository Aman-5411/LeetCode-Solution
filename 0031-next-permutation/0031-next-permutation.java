class Solution {
    private void reverse(int[] nums, int left) {
        int right = nums.length - 1;

        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int pvt = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]){
                pvt = i;
                break;
            }
        }

        if(pvt != -1) {
            for(int i = n - 1; i > pvt; i--){
                if(min > nums[i] && nums[pvt] < nums[i]){
                    min = nums[i];
                    minIdx = i;
                }
            }
            int temp = nums[pvt];
            nums[pvt] = nums[minIdx];
            nums[minIdx] = temp;
        }
        
        reverse(nums, pvt + 1);
    }
}