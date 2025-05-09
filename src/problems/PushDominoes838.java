package problems;

public class PushDominoes838 {
    public static void main(String[] args) {
        PushDominoes838 pushDominoes838 = new PushDominoes838();
        String ans = pushDominoes838.pushDominoes(".L.R...LR..L..");
        System.out.println(ans);
    }

    public String pushDominoes(String dominoes) {
        char[] ch = dominoes.toCharArray();
        int[] force = new int[dominoes.length()];
        int[] force1 = new int[dominoes.length()];
        int f = Integer.MAX_VALUE;
        for(int i = 0;i<ch.length;i++){
           if(ch[i] == 'R'){
               f = 0;
           }
            if(ch[i] == 'L'){
                f = Integer.MAX_VALUE;
            }
           force[i] = f;
           f--;
        }
        f = Integer.MAX_VALUE;
        for(int i = ch.length -1;i>-1;i--) {
            if (ch[i] == 'L') {
                f = 0;
            }
            if (ch[i] == 'R') {
                f = Integer.MAX_VALUE;
            }
            force1[i] = f;
            f--;
        }
        StringBuilder str= new StringBuilder();
        for(int i = 0;i<ch.length;i++){
            if(force[i] > 0 && force1[i] > 0 || force[i] == force1[i]){
                str.append('.');
            } else if (force[i] > 0 && force1[i] <= 0) {
                str.append('L');
            } else if (force1[i] > 0 && force[i] <= 0) {
                str.append('R');
            } else if (force[i] > force1[i]) {
                str.append('R');
            } else
                str.append('L');
        }
        return str.toString();
    }
}
