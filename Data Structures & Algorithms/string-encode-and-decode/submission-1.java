class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        int numStart = 0;
        List<String> result = new ArrayList<>();

        while (i < str.length()) {
            while (str.charAt(i) != '#') {
                i++;
            }

            // Determine the length of this string
            int length = Integer.parseInt(str.substring(numStart, i));
            i++;

            // Extract the original string 
            result.add(str.substring(i, i + length));

            i += length;
            numStart = i;
        }

        return result;
    }
}
