package icpc2020davao;

import java.util.Scanner;

public class DungeonBuilding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        //User input number of rooms
        int[][] rooms = new int[arrayLength][arrayLength];
        //User input of each index
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                rooms[i][j] = scanner.nextInt();
            }
        }
        printLevelMap(rooms);

    }

    public static void printLevelMap(int[][] rooms) {
        StringBuilder builder = new StringBuilder();
        char[][][][] levelMap = buildLevelMap(rooms);

        for (int row = 0; row < rooms.length; row++) {
            for (int c = 0; c < levelMap[row][0].length; c++) {
                for (int column = 0; column < rooms.length; column++) {
                    char[][] roomArea = levelMap[row][column];
                    builder.append(roomArea[c][0]);
                    builder.append(roomArea[c][1]);
                    builder.append(roomArea[c][2]);
                }
                builder.append(System.getProperty("line.separator"));
            }
        }
        System.out.println(builder.toString());
    }

    public static char[][][][] buildLevelMap(int[][] rooms) {
        char[][][][] levelMap = new char[rooms.length][rooms.length][][];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                if (rooms[i][j] == 0) {
                    levelMap[i][j] = new char[][]{
                        {'#', '#', '#'},
                        {'#', '.', '#'},
                        {'#', '#', '#'}
                    };
                } else if (rooms[i][j] == 1) {
                    levelMap[i][j] = new char[][]{
                        {'#', '#', '#'},
                        {'#', '#', '#'},
                        {'#', '#', '#'}
                    };
                }
            }
        }
        //Connect Horizontally
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                if ((j + 1 < rooms.length) && rooms[i][j] == 0 && rooms[i][j + 1] == 0) {
                    levelMap[i][j][1][2] = '.'; //left area
                    levelMap[i][j + 1][1][0] = '.'; //right area
                }
            }
        }
        //Connect Vertically
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                if ((j + 1 < rooms.length) && rooms[j][i] == 0 && rooms[j + 1][i] == 0) {
                    levelMap[j][i][2][1] = '.'; //upper area
                    levelMap[j + 1][i][0][1] = '.'; //lower area
                }
            }
        }
        return levelMap;
    }
}
