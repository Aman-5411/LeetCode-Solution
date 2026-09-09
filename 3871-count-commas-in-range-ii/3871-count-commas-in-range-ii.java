class Solution {
    public long countCommas(long n) {
        long res = 0;
        if(n < 1000)    return 0;

        for(int i = 1; i < 6; i++) {
            res += Math.max(0, n - (long)Math.pow(1000, i) + 1);
        }

        return res;
    }
}