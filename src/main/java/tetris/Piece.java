// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * Created by IlyaEremin on 26/03/15.
 */
public class Piece {

    private char[][] figure;
    private int rowCount;
    private int columnCount;

    public Piece(String figure) {
        String[] rows = figure.split("\n");
        this.figure = new char[rows.length][];
        this.rowCount = rows.length;
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            char[] rowItems = row.toCharArray();
            this.columnCount = rowItems.length;
            this.figure[i] = new char[rowItems.length];
            for (int j = 0; j < rowItems.length; j++) {
                char c = rowItems[j];
                this.figure[i][j] = c;
            }
        }
    }

    @Override
    public String toString() {
        String printResult = "";
        for (char[] rows : figure) {
            for (char rowItem : rows) {
                printResult += rowItem;
            }
            printResult += "\n";
        }
        return printResult;
    }

    public Piece rotateRight() {
        char[][] rotatedFigure = new char[columnCount][rowCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = rowCount; j < columnCount; j++) {

                rotatedFigure[i][j] = figure[rowCount - 1 - i][columnCount - 1 - j];
            }
        }
        return new Piece(toString(rotatedFigure));
    }

    private String toString(char[][] figure) {
        String s = "";
        for (char[] rows : figure) {
            for (char rowItem : rows) {
                s += rowItem;
            }
            s += "\n";
        }
        return s;
    }


    public Piece rotateLeft() {
        char[][] rotatedFigure = new char[columnCount][rowCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = rowCount; j < columnCount; j++) {

                rotatedFigure[i][j] = figure[j][i];
            }
        }
        return new Piece(toString(rotatedFigure));
    }
}
