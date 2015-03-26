// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Board {

    private final int rowsCount;
    private final int columnCount;
    private final char[][] cells;

    private Block fallingBlock;

    private static final char EMPTY_CELL = '.';

    public Board(int rows, int columns) {
        this.rowsCount = rows;
        this.columnCount = columns;
        cells = new char[rows][columns];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                cells[i][j] = '.';
            }
        }
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rowsCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                if(fallingBlock != null && fallingBlock.getColumn() == col && fallingBlock.getRow() == row){
                    s += fallingBlock.getSymbol();
                } else {
                    s += cells[row][col];
                }
            }
            s += "\n";
        }
        return s;
    }

    public boolean hasFalling() {
        return fallingBlock != null;
    }

    public void drop(Block block) {
        if(fallingBlock != null){
            throw new IllegalStateException("already falling");
        }
        this.fallingBlock = block;
    }

    public void tick() {
        if(fallingBlock != null){
            if(isBlockAtTheBottom(fallingBlock)) {
                cells[fallingBlock.getRow()][fallingBlock.getColumn()] = fallingBlock.getSymbol();
                fallingBlock = null;
            } else if (cells[fallingBlock.getRow() + 1][fallingBlock.getColumn()] != EMPTY_CELL) {
                cells[fallingBlock.getRow()][fallingBlock.getColumn()] = fallingBlock.getSymbol();
                fallingBlock = null;
            } else {
                fallingBlock.fall();
            }
        }

//
//        for (int column = 0; column < columnCount; column++) {
//            for (int row = rowsCount - 1; row > 0; row--) {
//                cells[row][column] = cells[row - 1][column];
//            }
//        }
//        for (int i = 0; i < columnCount; i++) {
//            cells[0][i] = EMPTY_CELL;
//        }
    }

    private boolean isBlockAtTheBottom(Block block) {
        return block.getRow() == rowsCount - 1;
    }
}
