class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] diff = new int[nums1.length];
        long k = (long) k1 + k2;
        long sum = 0;
        int maxDiff = 0;

        for(int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            sum += diff[i];
        }

        if(sum <= k) return 0;

        long[] cnt = new long[maxDiff + 1];
        for(int x : diff) cnt[x]++;

        for(int v = maxDiff; v >= 1; v--) {
            if(cnt[v] == 0) continue;

            if(k >= cnt[v]) {
                k -= cnt[v];
                cnt[v - 1] += cnt[v];
                cnt[v] = 0;
            }

            else {
                cnt[v - 1] += k;
                cnt[v] = cnt[v] - k;
                k = 0;
                break;
            }
        }

        long ans = 0;

        for(int i = 0; i < cnt.length; i++) {
            ans += (long) cnt[i] * i * i;
        }
        return ans;
    }
}