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
        int startLen = 0;
        int index = 0;
        List<String> res = new ArrayList<>();

        while (index < str.length()) {
            char c = str.charAt(index);
            if (c == '#') {
                int stringLen = Integer.parseInt(str.substring(startLen, index));
                res.add(str.substring(index + 1, index + 1 + stringLen));
                index = index + 1 + stringLen;
                startLen = index;
            } else {
                index++;
            }
        }

        return res;
    }
}
