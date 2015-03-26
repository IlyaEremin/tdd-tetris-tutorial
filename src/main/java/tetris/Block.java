// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * Created by IlyaEremin on 26/03/15.
 */
public class Block {

    private final char symbol;
    private int column;
    private int row;

    public Block(char symbol) {
        this.symbol = symbol;
        this.column = 1;
        this.row = 0;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void fall() {
        row++;
    }
}
