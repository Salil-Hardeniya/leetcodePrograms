package problems;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class LudoGenerator {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("count and turn");
        String l1 = sc.nextLine();
        String[] a = l1.split(" ");
        int pcount = Integer.parseInt(a[0]);
        int turns = Integer.parseInt(a[1]);
        String[] names = new String[pcount];
        for(int i = 0;i< pcount;i++){
            System.out.println("next name");
            names[i] = sc.nextLine();
        }
        Random random = new Random();
        int i = 0;
        while(turns > 0){
//            int dice = random.nextInt(1,7);
//
            int count = 1;
            int dice = 6;
            System.out.printf("%s turn %d dice rolled to: %d \n", names[i % pcount],turns,dice);
            while(dice == 6 && turns != 0 && count<3){
//                dice = random.nextInt(1,6);
                dice = 6;
                turns--;
                count++;
                System.out.printf("%s turn %d dice rolled to: %d \n", names[i % pcount],turns,dice);
            }
            turns--;
            i++;
        }
    }
}
