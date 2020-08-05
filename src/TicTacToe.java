
public class TicTacToe {

    private int[][] table;
    final static int PERSON = 1;
    final static int AI = 2;
    private int winner;

    public TicTacToe() {
        table = new int[3][3];
    }

    public boolean isSelected(int n) {
        return n == 1;
    }

    public void AIChoose() {
        int[] point;
        int x = 0, y = 0;
        if (isWinning(AI)) {
            AIChooseWin();
            printTable();
            System.out.println("AI Winner");
            winner = AI;
            System.exit(0);
        } else {
            //random that don't overwrite the existing number
            do {
                point = randomPoint();
                x = point[0];
                y = point[1];
                System.out.println("Temporary point: x = " + x + ", y = " + y);
            } while (table[x][y] != 0);

        }
        System.out.println("AI Choose Point: x = " + x + ", y = " + y);
        table[x][y] = AI;
        printTable();
    }

    private boolean isWinning(int player) {
        return horizontalPair(player) || verticalPair(player) || diagonalPair(player);
    }

    private void AIChooseWin() {

        if (horizontalPair(AI)) {
            for (int y = 0; y < table.length; y++) {
                int pair = 0;
                for (int x = 0; x < table.length; x++) {
                    if (table[x][y] == AI) {
                        pair += 1;
                    }
                }
                if (pair == 2) {
                    for (int x = 0; x < table.length; x++) {
                        if (table[x][y] == 0) {
                            table[x][y] = AI;
                        }
                    }
                    break;
                }
            }
        } else if (verticalPair(AI)) {
            for (int x = 0; x < table.length; x++) {
                int pair = 0;
                for (int y = 0; y < table.length; y++) {
                    if (table[x][y] == AI) {
                        pair += 1;
                    }
                }
                if (pair == 2) {
                    for (int y = 0; y < table.length; y++) {
                        if (table[x][y] == 0) {
                            table[x][y] = AI;
                        }
                    }
                }
            }
        } else if (diagonalPair(AI)) {
            boolean hasWon = false;
            int pair = 0;
            for (int i = 0; i < table.length; i++) {

                if (table[i][i] == AI) {
                    pair += 1;
                }
            }
            if (pair == 2) {
                for (int i = 0; i < table.length; i++) {
                    if (table[i][i] == 0) {
                        table[i][i] = AI;
                        hasWon = true;
                    }
                }
            }
            
            pair = 0;

            for (int i = table.length - 1; i >= 0; i--) {
                if (table[i][i] == AI) {
                    pair += 1;
                }
            }
            if (pair == 2 && !hasWon) {
                for (int i = table.length - 1; i >= 0; i--) {
                    if (table[i][i] == 0) {
                        table[i][i] = AI;
                    }
                }
            }
        }

    }

    private boolean horizontalPair(int player) {
        int pair = 0;
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                if (table[x][y] == player) {
                    pair += 1;
                }
            }

            if (pair == 2) {
                return true;
            }

            pair = 0;
        }
        return false;
    }

    private boolean verticalPair(int player) {
        int pair = 0;
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table.length; y++) {
                if (table[x][y] == player) {
                    pair += 1;
                }
            }

            if (pair == 2) {
                return true;
            }

            pair = 0;
        }
        return false;
    }

    private boolean diagonalPair(int player) {
        int pair = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i][i] == player) {
                pair += 1;
            }
        }
        if (pair == 2) {
            return true;
        }
        pair = 0;

        for (int i = table.length - 1; i >= 0; i--) {
            if (table[i][i] == player) {
                pair += 1;
            }
        }
        if (pair == 2) {
            return true;
        }
        return false;
    }

    private int[] randomPoint() {
        int x = new java.util.Random().nextInt((2 - 0) + 1) + 0;
        int y = new java.util.Random().nextInt((2 - 0) + 1) + 0;
        return new int[]{x, y};
    }

    public void printTable() {
        System.out.println("Table:");
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table.length; x++) {
                System.out.print(table[x][y]);
                if (y <= table.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.print(System.getProperty("line.separator"));
        }
    }

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.printTable();
        t.AIChoose();
        t.AIChoose();
        t.AIChoose();
        t.AIChoose();
        t.AIChoose();

    }
}
