/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/23/2023
 */

package leetcode.arraysandhashinng;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *  Only the filled cells need to be validated according to the mentioned rules.
 */
@SuppressWarnings("checkstyle:MagicNumber")
public class ValidSudoku {

    private final int ruleSize = 9;

    /**
     * simple method to parameterize and implement the 3 kinds of rules
     *
     * @param board
     * @return if they comply with the rules
     */
    public boolean isValidSudoku(char[][] board) {

        int[] rowBase = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] colBase = new int[] {0, 9, 18, 27, 36, 45, 54, 63, 72};
        int[] boxBase = new int[] {0, 1, 2, 9, 10, 11, 18, 19, 20};

        // doRows
        for (int i = 0; i < ruleSize; i++) {
            if (!checkSubset(board, rowBase)) {
                return false;
            }
            for (int j = 0; j < ruleSize; j++) {
                rowBase[j] += ruleSize;
            }
        }
        // doCols
        for (int i = 0; i < ruleSize; i++) {
            if (!checkSubset(board, colBase)) {
                return false;
            }
            for (int j = 0; j < ruleSize; j++) {
                colBase[j] += 1;
            }
        }
        // doboxes
        for (int i = 0; i < ruleSize; i++) {
            if (!checkSubset(board, boxBase)) {
                return false;
            }
            for (int j = 0; j < ruleSize; j++) {
                boxBase[j] += 3;
            }
            if ((i % 3) == 2) {
                for (int j = 0; j < ruleSize; j++) {
                    boxBase[j] += 18;
                }
            }
        }

        return true;
    }

    private boolean checkSubset(char[][] b, int[] index) {
        List<Integer> outList = new ArrayList();
        for (int i : index) {
            int r = i / ruleSize;
            int c = i % ruleSize;
            char cell = b[r][c];
            if (cell == '.') {
                continue;
            }
            if (Character.isDigit(cell) && cell != '0') {
                if (outList.contains(new Integer(cell))) {
                    return false;
                } else {
                    outList.add(new Integer(cell));
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
