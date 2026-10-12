class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long mod = 1_000_000_007;
        int[] bits = new int[30];
        long sum = 0;
        
        for(int num : nums) {
            for(int b = 0; b < 30; b++) {
                if((num & (1 << b)) != 0) {
                    bits[b]++;
                }
            }
        }

        while(k-- > 0) {
            long curr = 0;
            for(int b = 0; b < 30; b++) {
                if(bits[b]-- > 0)    curr = (curr | (1 << b));
            }
            sum = (sum + (curr * curr)) % mod;
        }      
        return (int)sum ;
    }
}