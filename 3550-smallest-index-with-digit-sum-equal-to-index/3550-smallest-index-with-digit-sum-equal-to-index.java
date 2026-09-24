class Solution {
    private int sumDig(int num) {
        int sum = 0;
        while(num != 0) {
            int rem = num % 10;
            sum = sum + rem;
            num = num/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int idx = -1;
        
        for(int i = 0; i < nums.length; i++) {
            int sum = sumDig(nums[i]);
            if(sum == i){
                idx = i;
                break;
            }
        }
        return idx;
    }
}