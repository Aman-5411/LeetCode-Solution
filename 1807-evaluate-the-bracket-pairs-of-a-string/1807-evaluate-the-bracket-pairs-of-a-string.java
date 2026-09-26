class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(List<String> l : knowledge) {
            String newStr = l.get(0);
            mp.put(newStr, l.get(1));
        }

        System.out.println(mp);
        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') {
                int idx = i;
                while(s.charAt(i) != ')') {
                    i++;
                }

                String key = s.substring(idx + 1, i);

                if(mp.containsKey(key)){
                    sb.append(mp.get(key));
                }

                else{
                    sb.append("?");
                }
            }

            else{
                sb.append(s.charAt(i));
            }

        }

        return sb.toString();
    }
}