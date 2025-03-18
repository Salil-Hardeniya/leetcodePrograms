package problems;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MinimumTImeRepairCar2594 {
    public static void main(String[] args) {
        MinimumTImeRepairCar2594 minimumTImeRepairCar2594 = new MinimumTImeRepairCar2594();
        int[] ranks = {4,2,3,1};
        long ans = minimumTImeRepairCar2594.repairCars(ranks, 10);
        System.out.println(ans);
    }

    public long repairCars(int[] ranks, int cars) {
        int minRank = ranks[0], maxRank = ranks[0];
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
            maxRank = Math.max(maxRank, rank);
        }
        long low = 1, high = (long) minRank * cars * cars;
        int[] freq = new int[maxRank + 1];
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
            freq[rank]++;
        }
        while(low < high){
            long mid = (high + low)/2;
            long carsRepaired = 0;
            for (int rank = 1; rank <= maxRank; rank++) {
                carsRepaired +=
                        freq[rank] * (long) Math.sqrt((double) mid / (long) rank);
            }

            if(carsRepaired < cars){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        return low;
    }
}
