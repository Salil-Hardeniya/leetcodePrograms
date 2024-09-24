package problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseSebstringBwParenthesis1190 {

    public static void main(String[] args) {
        System.out.println(reverseParentheses("ta()usw((((a))))"));

        Stack<Integer> st = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<Integer>();

    }

    public static String reverseParentheses(String s) {
        String str = "(" + s + ")";
        StringBuilder sb = reverse(str.toCharArray(),1,str.length()-2);
        return sb.reverse().toString();
    }

    static StringBuilder reverse(char[] ch, int s, int e){
        StringBuilder sb = new StringBuilder();
        if(s > e)
            return sb;
        while(s <= e ){
            if(ch[s] != '(' && ch[s] != ')'){
                sb.append(ch[s]);
                s++;
            }else if(ch[s] == '(' ){
                int count = 1;
                int start = s;
                while(count !=0){
                    s++;
                    if(ch[s] == '(')
                        count++;
                    else if(ch[s] == ')')
                        count--;
                }
                sb.append(reverse(ch,start+1,s-1));
            }else{
                s++;
            }
        }
        return sb.reverse();
    }
}
