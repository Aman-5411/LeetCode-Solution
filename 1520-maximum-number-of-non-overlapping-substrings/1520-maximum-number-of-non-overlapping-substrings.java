class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> ans = new ArrayList<>();
        int[] start = new int[26];
        int[] end = new int[26];
        boolean[] flag = new boolean[26];

        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        Arrays.fill(flag, true);

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(start[ch - 'a'] == -1){
                start[ch - 'a'] = i;
            }

            end[ch - 'a'] = i;
        }


        /**
        Main Logic --> we will check from each character starting idx to ending idx and if found a char whose starting idx is less than curr char starting idx we mark it is false 

        Also if we found a char whose ending idx is greater than curr char ending idx we will update the end[c] and that's all. |
        **/

        for(int c = 0; c < 26; c++) {
            if(start[c] == -1)
                continue;

            for(int i = start[c]; i <= end[c]; i++) {
                if(start[s.charAt(i) - 'a'] < start[c]){
                    flag[c] = false;
                    break;
                }

                else if(end[s.charAt(i) - 'a'] > end[c]){
                    end[c] = end[s.charAt(i) - 'a'];
                }
            }
        }
        int lastIdx = Integer.MAX_VALUE;
        for(int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';

            if(!flag[idx]) continue;

            if(i == start[idx] && end[idx] < lastIdx){
                ans.add(s.substring(i, end[idx] + 1));
                lastIdx = i;
            }

        }
        return ans;
    }
}