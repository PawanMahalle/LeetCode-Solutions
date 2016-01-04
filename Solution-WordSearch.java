/**
 * Problem Statement: https://leetcode.com/problems/word-search
 * 
 * @author PawanMahalle
 *
 */

public class Solution {
    
    int[] rowOffset = { 0, -1, 0, 1 };
    int[] colOffset = {-1, 0, 1, 0};
    int movementCount = 4;
    
    public boolean exist(char[][] board, String word) {
        char firstLetter = word.charAt(0);
        
        int rowCount = board.length;
        int colCount = board[0].length;
        
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < colCount; j++){
                if(board[i][j] == firstLetter){
                    
                    if(word.length() == 1){
                        return true;
                    }
                    
                    boolean visited[][] = new boolean[rowCount][colCount];
                    visited[i][j] = true;
                    if(search(board, i , j, word, 1, visited)){
                    	return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, int currentRow, int currentCol, String word, int index, boolean[][] visited){
        
        if(index == word.length()){
            return true;
        }
        
        int rowCount = board.length;
        int colCount = board[0].length;
        
        for(int i  = 0; i < movementCount; i++){
                int newRow = currentRow + rowOffset[i];
                int newCol = currentCol + colOffset[i];
                
                if(newRow >= rowCount || newRow < 0 || newCol >= colCount || newCol < 0 || visited[newRow][newCol]){
                    //If newRow or newCol goes out of board, simply skip prcessing and continue.
                    continue;
                }
                
                if(board[newRow][newCol] == word.charAt(index)){
                    
                    visited[newRow][newCol] = true;
                    
                    if(search(board, newRow , newCol, word, index + 1, visited)){
                        return true;
                    }
                    visited[newRow][newCol] = false;
                }
                
            }
        
        
        return false;
    }
}