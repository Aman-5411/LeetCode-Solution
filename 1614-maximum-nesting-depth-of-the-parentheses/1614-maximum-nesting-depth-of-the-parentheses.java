class Solution {
    public int maxDepth(String s) {
        int counter = 0;
        int maxCounter = Integer.MIN_VALUE;

        for(char ch : s.toCharArray()){
            if(ch == '(')   counter++;

            else if(ch ==')')    counter--;

            maxCounter = Math.max(maxCounter, counter);
        }
        return maxCounter;
    }
}