package bartlett.chelsea.javasudoku;

import bartlett.chelsea.javasudoku.impl.Board;

public class Main {
	

	
	
	
	public static void main (String[] args){
		final Board HOORAY = new Board();
		HOORAY.initializeFromUserInput();
		System.out.println(HOORAY);
	}
}
