class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded_string = new StringBuilder();
        for(String s : strs){
           encoded_string.append(s.length()).append("#").append(s) ;
        }
        return encoded_string.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded_strs = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int separator = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, separator));
            String word = str.substring(separator + 1, separator + 1 + length);
            decoded_strs.add(word);
            i = separator + 1 + length;
        }
        return decoded_strs;

    }
}
