package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NeetCodeValidSudoku {
    public static void main(String[] args) {
        char[][] board ={{'1','2','.','.','3','.','.','.','.'},
                        {'4','.','.','5','.','.','.','.','.'},
                        {'.','9','8','.','.','.','.','.','3'},
                        {'5','.','.','.','6','.','.','.','4'},
                        {'.','.','.','8','.','3','.','.','5'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','.','.','.','.','.','2','.','.'},
                        {'.','.','.','4','1','9','.','.','8'},
                        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> sqr = new HashMap<>();
        for(int i=0;i<9;i++){
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            sqr.put(i, new HashSet<>());
        }

        for(int i=0;i<9;i++){
            for(int j = 0;j<9;j++){
                char c = board[i][j];
                if(c == '.')
                    continue;

                if(!row.get(i).add(c))
                    return false;
                if(!col.get(j).add(c))
                    return false;
                int sq = (i/3)*3 + (j/3);
                if(!sqr.get(sq).add(c))
                    return false;
            }
        }
        return true;

    }
}
