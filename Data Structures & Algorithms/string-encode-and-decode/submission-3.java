class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String s : strs) {
            sb.append(s.length() + "");
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimiter = i;
            
            while (str.charAt(delimiter) != '#') {
                delimiter++;
            }

            int length = Integer.parseInt(str.substring(i, delimiter));
            result.add(str.substring(delimiter + 1, delimiter + 1 + length));

            i = delimiter + 1 + length;
        }

        return result;
    }
}
