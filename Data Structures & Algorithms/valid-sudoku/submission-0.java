class Solution {
    public boolean isValidSudoku(char[][] board) {       
        for (int row = 0; row < 9; row++) {
            HashSet<Character> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char cell = board[row][col];
                if (cell != '.') {
                    if (seen.contains(cell)) {
                        return false;
                    }
                    seen.add(cell);
                }
            }
        }
        
        for (int col = 0; col < 9; col++) {
            HashSet<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char cell = board[row][col];
                if (cell != '.') {
                    if (seen.contains(cell)) {
                        return false;
                    }
                    seen.add(cell);
                }
            }
        }
        
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                HashSet<Character> seen = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int row = boxRow * 3 + i;
                        int col = boxCol * 3 + j;
                        char cell = board[row][col];
                        if (cell != '.') {
                            if (seen.contains(cell)) {
                                return false;
                            }
                            seen.add(cell);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}