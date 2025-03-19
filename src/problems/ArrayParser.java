package problems;

import java.util.Arrays;

public class ArrayParser {
    public static int[] parse1DArray(String str){
        str = str.replaceAll(" ","").substring(1,str.length()-1);
        String[] ar = str.split(",");
        return Arrays.stream(ar).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] parse2DArray(String str) {
        str = str.trim();
        if (str.equals("[]")) return new int[0][0];  // Handle empty 2D array case

        str = str.substring(1, str.length() - 1).trim();  // Remove outer brackets
        if (str.isEmpty()) return new int[0][0];  // Handle empty content

        String[] rows = str.split("],\\s*\\[");  // Split by "],[" to get sub-arrays
        return Arrays.stream(rows)
                .map(row -> row.replaceAll("[\\[\\]]", "").trim()) // Remove brackets
                .map(row -> row.isEmpty() ? new int[0] : Arrays.stream(row.split("\\s*,\\s*"))
                        .mapToInt(Integer::parseInt)
                        .toArray()) // Convert to int[]
                .toArray(int[][]::new); // Convert to int[][]
    }

}
