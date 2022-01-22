package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidSudoku {

    private int MAX_LENGTH = 9;

    private Map<Character, Boolean> row = new HashMap<>();
    private Map<Character, Boolean> column = new HashMap<>();


    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {

                char rowNumber = board[i][j];
                char columnNumber = board[j][i];

                if (row.containsKey(rowNumber) && rowNumber != 46) {
                    return false;
                }

                if (column.containsKey(columnNumber) && columnNumber != 46) {
                    return false;
                }


                row.put(rowNumber, true);
                column.put(columnNumber, true);
            }
            row.clear();
            column.clear();
        }

        return table(board);
    }

    private boolean table(char[][] board) {
        
        LinkedList<Character> check = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        check.add(board[0][0]);
        check.add(board[0][1]);
        check.add(board[0][2]);
        check.add(board[1][0]);
        check.add(board[1][1]);
        check.add(board[1][2]);
        check.add(board[2][0]);
        check.add(board[2][1]);
        check.add(board[2][2]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();


        check.add(board[3][0]);
        check.add(board[3][1]);
        check.add(board[3][2]);
        check.add(board[4][0]);
        check.add(board[4][1]);
        check.add(board[4][2]);
        check.add(board[5][0]);
        check.add(board[5][1]);
        check.add(board[5][2]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();

        check.add(board[6][0]);
        check.add(board[6][1]);
        check.add(board[6][2]);
        check.add(board[7][0]);
        check.add(board[7][1]);
        check.add(board[7][2]);
        check.add(board[8][0]);
        check.add(board[8][1]);
        check.add(board[8][2]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();

        /////////////////////

        check.add(board[0][3]);
        check.add(board[0][4]);
        check.add(board[0][5]);
        check.add(board[1][3]);
        check.add(board[1][4]);
        check.add(board[1][5]);
        check.add(board[2][3]);
        check.add(board[2][4]);
        check.add(board[2][5]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();


        check.add(board[3][3]);
        check.add(board[3][4]);
        check.add(board[3][5]);
        check.add(board[4][3]);
        check.add(board[4][4]);
        check.add(board[4][5]);
        check.add(board[5][3]);
        check.add(board[5][4]);
        check.add(board[5][5]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();

        check.add(board[6][3]);
        check.add(board[6][4]);
        check.add(board[6][5]);
        check.add(board[7][3]);
        check.add(board[7][4]);
        check.add(board[7][5]);
        check.add(board[8][3]);
        check.add(board[8][4]);
        check.add(board[8][5]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();

        //

        check.add(board[0][6]);
        check.add(board[0][7]);
        check.add(board[0][8]);
        check.add(board[1][6]);
        check.add(board[1][7]);
        check.add(board[1][8]);
        check.add(board[2][6]);
        check.add(board[2][7]);
        check.add(board[2][8]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();


        check.add(board[3][6]);
        check.add(board[3][7]);
        check.add(board[3][8]);
        check.add(board[4][6]);
        check.add(board[4][7]);
        check.add(board[4][8]);
        check.add(board[5][6]);
        check.add(board[5][7]);
        check.add(board[5][8]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();

        check.add(board[6][6]);
        check.add(board[6][7]);
        check.add(board[6][8]);
        check.add(board[7][6]);
        check.add(board[7][7]);
        check.add(board[7][8]);
        check.add(board[8][6]);
        check.add(board[8][7]);
        check.add(board[8][8]);

        for (Character character : check) {
            if(list.contains(character)) {
                return false;
            }
            if (character != 46)
                list.add(character);
        }

        check.clear();
        list.clear();

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new ValidSudoku().isValidSudoku(
//                new char[][]
//                        {
//                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
//                                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//                        }
//        ));
        System.out.println(new ValidSudoku().isValidSudoku(
                new char[][]
                        {
                                {'1', '.', '.', '.', '.', '.', '.', '.', '2'}
                                ,{'.', '1', '.', '.', '.', '.', '6', '.', '.'}
                                ,{'.', '.', '1', '4', '.', '.', '8', '.', '.'}
                                ,{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                                ,{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                                ,{'.', '.', '.', '.', '3', '.', '.', '.', '.'}
                                ,{'5', '.', '8', '6', '.', '.', '.', '.', '.'}
                                ,{'.', '9', '.', '.', '.', '.', '4', '.', '.'}
                                ,{'.', '.', '.', '.', '5', '.', '.', '.', '.'}
                        }
        ));

//        System.out.println(new ValidSudoku().isValidSudoku(
////                new char[][]
////                        {
////                                {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
////                                ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
////                                ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
////                                ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
////                                ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
////                                ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
////                                ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
////                                ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
////                                ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
////                        }
////        ));
    }

}
