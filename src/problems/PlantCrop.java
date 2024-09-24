package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlantCrop {
    public static void main(String[] args) {
            List<List<Character>> grid = new ArrayList<>();
            grid.add(Arrays.asList('a', 'a', 'a', 'a'));
            grid.add(Arrays.asList('a', 'a', 'a', 'a'));
            grid.add(Arrays.asList('a', 'a', 'a', 'a'));
            grid.add(Arrays.asList('a', 'a', 'a', 'a'));
        Collections.sort(grid.get(0));

            int m = grid.size();
            int n = grid.get(0).size();
            List<List<Integer>> dp = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(0);
                }
                dp.add(row);
            }

            int res = 0;
            for (int i = 1; i < n; i++) {
                if (grid.get(0).get(i) == grid.get(0).get(i - 1)) {
                    if (dp.get(0).get(i - 1) == 0) {
                        dp.get(0).set(i, 1);
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (grid.get(i).get(j) == grid.get(i - 1).get(j)) {
                        if (dp.get(i - 1).get(j) != 1) {
                            dp.get(i).set(j, 1);
                        }
                    }

                    if (grid.get(i).get(j) == grid.get(i).get(j - 1)) {
                        if (dp.get(i).get(j - 1) != 1) {
                            dp.get(i).set(j, 1);
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(dp.get(i).get(j) + " ");
                    if (dp.get(i).get(j) == 1) {
                        res++;
                    }
                }
                System.out.println();
            }

            System.out.println(res);
        }


    }