class Solution {
    public String reverseParentheses(String s) {
       StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == ')') {
                StringBuilder rev = new StringBuilder();

                while(sb.charAt(sb.length() - 1) != '(') {
                    rev.append(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                
                sb.deleteCharAt(sb.length() - 1);
                sb.append(rev);
            }

            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}