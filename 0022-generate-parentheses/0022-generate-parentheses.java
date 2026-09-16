class Solution {
    private List<String> ans;

    private boolean isValid(StringBuilder sb) {
        Stack<Character> st = new Stack<>();

        if(sb.charAt(0) == ')') return false;

        for(int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == '('){
                st.push(ch);
            }
            else{  
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
    private void helper(StringBuilder sb, int n, List<String> ans) {
        
        if(sb.length() == 2 * n){
            if(isValid(sb)){
                ans.add(sb.toString());
            }
            return;
        }

        sb.append("(");
        helper(sb, n, ans); //Explore
        sb.deleteCharAt(sb.length() - 1); //Backtrack

        sb.append(")"); 
        helper(sb, n, ans); //Explore
        sb.deleteCharAt(sb.length() - 1); //Backtrack

    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, n, ans);
        return ans;
    }
}