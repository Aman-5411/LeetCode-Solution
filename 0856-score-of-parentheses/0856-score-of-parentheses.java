class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;      
        int depth = 0;    
      
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } 
            else {  
                depth--;
                if (s.charAt(i - 1) == '(') {
                    // Each "()" at depth d contributes 2^d to the total score
                    // Using bit shift: 1 << d equals 2^d
                    score += Math.pow(2, depth);
                }
            }
        }
      
        return score;
    }
}
