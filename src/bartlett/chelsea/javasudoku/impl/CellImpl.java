package bartlett.chelsea.javasudoku.impl;

import java.util.HashSet;
import java.util.Set;

import bartlett.chelsea.javasudoku.api.Cell;

public class CellImpl implements Cell {

	private final Set<Integer> _possibleValues;
	
	public CellImpl(){
		_possibleValues = new HashSet<Integer>();
		for (int v = 1; v < 10; v++){
			_possibleValues.add(v);
		}
	}
	
	@Override
	public boolean isPossibleValue(int value) {
		return _possibleValues.contains(value);
	}

	@Override
	public boolean isSolved() {
		return _possibleValues.size() == 1;
	}

	@Override
	public Set<Integer> possibleValues() {
		return new HashSet<Integer>(_possibleValues);
	}

	@Override
	public void setIsNotPossibleValue(int value) {
		_possibleValues.remove(value);
	}

	@Override
	public void setValue(int value){
		_possibleValues.clear();
		_possibleValues.add(value);
	}
	
	@Override
	public int getSolvedValue(){
		if (isSolved()){
			for(final Integer value: _possibleValues){
				return value;
			}
			throw new IllegalStateException("No values left");
		} else {
			throw new IllegalStateException("Not Solved");
		}
	}
	
}
