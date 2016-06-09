package com.leetcode.qindipku.java._37SudokuSolver;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution. 
 * 
 * @author qindi
 *
 */
public class _37SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    /*private boolean solve(char[][] board, int i, int j) {
        if (board[i][j] == '.') {
            for (char n = '1'; n <= '9'; n++) {
                board[i][j] = n;
                
                if (isValidSudoku(board)) {
                    if (i == 8 && j == 8) {
                        return true;
                    } else if (j < 8) {
                        if (solve(board, i, j + 1)) {
                            return true;
                        }
                    } else {
                        if (solve(board, i + 1, 0)) {
                            return true;
                        }
                    }
                }
            }
            
            board[i][j] = '.';
        } else {
            if (j < 8) {
                if (solve(board, i, j + 1)) {
                    return true;
                }
            } else {
                if (solve(board, i + 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }*/
    
    private boolean solve(char[][] board, int i, int j) {
        System.out.println("=============" + i + ":" + j + "============");
        printArr(board);
        if (board[i][j] == '.') {
            for (char n = '1'; n <= '9'; n++) {
                board[i][j] = n;
                
                //if (isValidSudoku(board)) {
                if (isValidSudoku(board, i, j)) {
                    if (i == 8 && j == 8) {
                        System.out.println("=============result=============");
                        printArr(board);
                        System.out.println("=============result=============");
                        return true;
                    } else if (j < 8) {
                        if (solve(board, i, j + 1)) {
                            return true;
                        }
                    } else {
                        if (solve(board, i + 1, 0)) {
                            return true;
                        }
                    }
                }
            }
            
            board[i][j] = '.';
        } else {
            if (j < 8) {
                if (solve(board, i, j + 1)) {
                    return true;
                }
            } else if (i < 8) {
                if (solve(board, i + 1, 0)) {
                    return true;
                }
            } else {
                //if (isValidSudoku(board)) {
                if (isValidSudoku(board, i, j)) {
                    return true;
                }
            }
            
        }
        return false;
    }
    
    
    public boolean isValidSudoku(char[][] board, int x, int y) {
        boolean[] flag;
        
        flag = new boolean[9];
        //x所在的列是否有效
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == '.') {
                continue;
            }
            
            int idx = board[x][i] - '1';
            
            if (flag[idx]) {
                return false;
            } else {
                flag[idx] = true;
            }
        }
        
        flag = new boolean[9];
        //y所在的行是否有效
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == '.') {
                continue;
            }
            
            int idx = board[i][y] - '1';
            
            if (flag[idx]) {
                return false;
            } else {
                flag[idx] = true;
            }
        }
        
        flag = new boolean[9];
        //x,y所在的3*3的方格是否有效
        for (int i = (x / 3 * 3); i < ((x / 3 + 1) * 3); i++) {
            for (int j = (y / 3 * 3); j < ((y / 3 + 1) * 3); j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                int idx = board[i][j] - '1';
                
                if (flag[idx]) {
                    return false;
                } else {
                    flag[idx] = true;
                }
            }
        }
        
        return true;
    }
    
    public void printArr(char[][] board) {
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    
    
    public boolean isValidSudoku(char[][] board) {
        boolean[] flag;
        int idx;

        //看看每行是不是
        for (int i = 0; i < 9; i++) {
            flag = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                idx = board[i][j] - '1';
                if (flag[idx]) {
                    return false;
                } else {
                    flag[idx] = true;
                }
            }
        }

        //看看每列是不是
        for (int i = 0; i < 9; i++ ) {
            flag = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }

                idx = board[j][i] - '1';
                if (flag[idx]) {
                    return false;
                } else {
                    flag[idx] = true;
                }
            }
        }

        //看看每个3×3的方格是不是满足条件
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                flag = new boolean[9];
                for (int m = i * 3; m < 3 * (i + 1); m++) {
                    for (int n = j * 3; n < 3 * (j + 1); n++) {
                        if (board[m][n] == '.') {
                            continue;
                        }

                        idx = board[m][n] - '1';
                        if (flag[idx]) {
                            return false;
                        } else {
                            flag[idx] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        String[] arr = new String[]{"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
        char[][] board = new char[9][9];
        
        for (int i = 0; i < 9; i++) {
            board[i] = arr[i].toCharArray();
        }
        
        _37SudokuSolver solution = new _37SudokuSolver();
        
        System.out.println("Before solve Sudoku...");
        solution.printArr(board);
        
        solution.solveSudoku(board);
        System.out.println("After solve Sudoku...");
        solution.printArr(board);
    
    }
}
