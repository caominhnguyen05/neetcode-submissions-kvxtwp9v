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
        List<String> ans = new ArrayList<>();

        int i = 0;
        int startNum = 0;

        while (i < str.length()) {
            while (str.charAt(i) != '#') {
                i++;
            }

            int thisStringLen = Integer.parseInt(str.substring(startNum, i));

            i += 1;
            ans.add(str.substring(i, i + thisStringLen));
            i += thisStringLen;
            startNum = i;
        }

        return ans;
    }
}
