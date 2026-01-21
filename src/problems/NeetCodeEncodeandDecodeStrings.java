package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeetCodeEncodeandDecodeStrings {
    public static void main(String[] args) {
        List<String> a = List.of("Hello","World");
        String ar = encode(a);
        List<String> b = decode(ar);
        System.out.println(b);

    }

    public static String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strs.size()).append('#');
        for(String str : strs){
            int l = str.length();
            stringBuilder.append(l).append('|').append(str);
        }
        return stringBuilder.toString();
    }

    public static List<String> decode(String str) {
        int l = str.indexOf('#');
        int n = Integer.parseInt(str.substring(0,l));
        List<String> ans = new ArrayList<>();
        int start = l+1;
        for(int i = 0;i<n;i++){
            l = str.indexOf('|',start);
            int len = Integer.valueOf(str.substring(start,l));
            start = l+1;
            String st = str.substring(start, start + len);
            ans.add(st);
            start = start + len;
        }
        return ans;
    }
}
