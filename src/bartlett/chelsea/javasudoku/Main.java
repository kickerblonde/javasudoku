package bartlett.chelsea.javasudoku;

import bartlett.chelsea.javasudoku.impl.Board;

public class Main {
	

	
	
	
	public static void main (String[] args){
		final Board HOORAY = new Board();
		HOORAY.get(0, 0).setValue(3);
		HOORAY.get(3,5).setValue(9);
		System.out.println(HOORAY);
	}
}
