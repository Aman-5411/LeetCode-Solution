class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(List<String> l : knowledge) {
            String newStr = '(' + l.get(0) + ')';
            map.put(newStr, l.get(1));
        }

        System.out.println(map);
        String[] parts = s.split("(?<=\\))|(?=\\()");

        for(int i = 0; i < parts.length; i++) {
            String str = parts[i];

            if(str.charAt(0) != '('){
                sb.append(str);
            }

            else if(map.containsKey(str)){
                sb.append(map.get(str));
            }

            else{
                sb.append("?");
            }
        }
        return sb.toString();
    }
}