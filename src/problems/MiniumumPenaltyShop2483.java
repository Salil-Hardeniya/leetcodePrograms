package problems;

public class MiniumumPenaltyShop2483 {
    public static void main(String[] args) {
        MiniumumPenaltyShop2483 miniumumPenaltyShop2483 = new MiniumumPenaltyShop2483();
        int ans = miniumumPenaltyShop2483.bestClosingTime("NNNN");
        System.out.println(ans);

    }

    public int bestClosingTime(String customers) {
        char[] customerArray = customers.toCharArray();
        int length = customerArray.length;
        int penalty = 0;
        int index = length;
        for(char ch : customerArray){
            if(ch == 'N')
                ++penalty;
        }
        int ans = penalty;
        for(int i = length -1; i>=0;i--){
            if(customerArray[i] == 'Y')
                ++penalty;
            else
                --penalty;
            if(penalty <= ans){
                ans = penalty;
                index = i;
            }
        }
        return index;
    }
}
