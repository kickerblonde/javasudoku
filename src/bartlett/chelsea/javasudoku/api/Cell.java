package bartlett.chelsea.javasudoku.api;

import java.util.Set;

public interface Cell {
	public int getX();
	public int getY();
	public boolean isPossibleValue(int value);
	public boolean isSolved();
	public Set<Integer> possibleValues();
	public void setIsNotPossibleValue(int value);
	public void setValue(int value);
	public int getSolvedValue();
	
}
