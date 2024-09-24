package problems;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new ArrayDeque<>();
        int ans = 0;
        outer: while(true){
            String l1 = sc.nextLine();
            q.offer(l1);
            if(q.size() > 3)
                q.poll();
            String[] a = l1.split(" ", -1);
            String op = a[0];
            switch (op){
                case "add" : {
                    int n1 = Integer.parseInt(a[1]);
                    int n2 = Integer.parseInt(a[2]);
                    ans = n1 + n2;
                    System.out.println(ans);
                    break;
                }
                case "sub" :
                {
                    int n1 = Integer.parseInt(a[1]);
                    int n2 = Integer.parseInt(a[2]);
                    ans = n1 - n2;
                    System.out.println(ans);
                    break;
                }
                case "answer" :
                    System.out.println(ans);
                    break;
                case "history" : {
                    for (String str: q) {
                        System.out.println(str);
                    }
                }
                break;
                case "exit" : break outer;
            }
        }
    }
}
