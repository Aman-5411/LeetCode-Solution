class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int i = 0, j = 0;
        int bestMin = Integer.MAX_VALUE;
        int currSum = 0, len = 0;
        int res = Integer.MAX_VALUE;

        int[] minPre = new int[arr.length];
        Arrays.fill(minPre, Integer.MAX_VALUE);


        while(j < arr.length) {
            currSum += arr[j];

            while(currSum > target){
                currSum -= arr[i];
                i++;
            }
            if(currSum == target) {
                len = j - i + 1;
                if(i > 0 && minPre[i - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, len + minPre[i - 1]);
                }

                bestMin = Math.min(bestMin, len);
            }
            minPre[j] = bestMin;
            j++;
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}