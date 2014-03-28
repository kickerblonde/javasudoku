package bartlett.chelsea.javasudoku.impl;

import bartlett.chelsea.javasudoku.api.Cell;

public class Board {

	private static final int BOARD_DIMENSION = 9;
	private static final int BLOCK_SIZE = BOARD_DIMENSION / 3;

	private final Cell[][] _cells;

	private final CellGroup[] _rows;
	private final CellGroup[] _columns;
	private final CellGroup[] _blocks;

	public Board() {
		_cells = new Cell[BOARD_DIMENSION][];
		_rows = new CellGroup[BOARD_DIMENSION];
		_columns = new CellGroup[BOARD_DIMENSION];
		_blocks = new CellGroup[BOARD_DIMENSION];

		// actually create all the cells in the board
		for (int y = 0; y < BOARD_DIMENSION; y++) {
			final Cell[] row = new Cell[BOARD_DIMENSION];
			_cells[y] = row;
			for (int x = 0; x < BOARD_DIMENSION; x++) {
				row[x] = new CellImpl(x, y);
			}
		}

		// populate rows
		for (int y = 0; y < BOARD_DIMENSION; y++) {
			_rows[y] = new CellGroup(_cells[y]);
		}

		// populate columns
		for (int x = 0; x < BOARD_DIMENSION; x++) {
			final Cell[] column = new Cell[BOARD_DIMENSION];
			for (int y = 0; y < BOARD_DIMENSION; y++) {
				column[y] = _cells[y][x];
			}
			_columns[x] = new CellGroup(column);
		}

		// populate blocks
		for (int b = 0; b < BOARD_DIMENSION; b++) {
			final Cell[] block = new Cell[BOARD_DIMENSION];
			final int xOffSet = (b % 3) * BLOCK_SIZE;
			final int yOffSet = (b / 3) * BLOCK_SIZE;
			for (int x = 0; x < BLOCK_SIZE; x++) {
				for (int y = 0; y < BLOCK_SIZE; y++) {
					block[x * BLOCK_SIZE + y] = _cells[yOffSet + y][xOffSet + x];
				}
			}
			_blocks[b] = new CellGroup(block);
		}

	}

	public Cell get(final int x, final int y) {
		return _cells[y][x];
	}

	public CellGroup getRow(final int y) {
		return _rows[y];
	}

	public CellGroup getColumn(final int x) {
		return _columns[x];
	}

	public CellGroup getBlock(final int idx) {
		return _blocks[idx];
	}

	public String toString(){
		final StringBuilder sb = new StringBuilder();
		for( int y = 0; y < BOARD_DIMENSION; y++){
			for( int x = 0; x < BOARD_DIMENSION; x++){
				sb.append(get(x,y).toString());
			}
			sb.append("\n");
		}
		return sb.toString();		
	}
}
