package bartlett.chelsea.javasudoku.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bartlett.chelsea.javasudoku.api.Cell;

public class CellGroup {
	private final List<Cell> _cells;

	public CellGroup(final Cell... cs) {
		final List<Cell> cells = new ArrayList<Cell>();
		for (final Cell cell : cs) {
			cells.add(cell);
		}
		_cells = Collections.unmodifiableList(cells);
	}

	public List<Cell> getCells() {
		return _cells;
	}
}