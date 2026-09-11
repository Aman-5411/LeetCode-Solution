class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        HashSet<Integer> set = new HashSet<>();
        

        for(int i = 0; i < n; i++) { 
            if(digits[i] % 2 == 1)  continue;

            for(int j = 0; j < n; j++) {
                if(i == j) continue;
               
                for(int k = 0; k < n; k++) {
                    if(digits[k] == 0 ||k == j||k == i)  continue;

                    int num = digits[k] * 100 + digits[j] * 10 + digits[i];
                    set.add(num);
                } 
            }
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(int num : set) {
            ans[i++] = num; 
        }

        Arrays.sort(ans);

        return (ans);
    }
}